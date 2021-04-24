package com.ibtikar.todolisttask.ui.add_task.presentation

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.ibtikar.todolisttask.databinding.ActivityAddTaskBinding
import com.ibtikar.todolisttask.ui.TodoApplication
import com.ibtikar.todolisttask.ui.base.BaseActivity
import javax.inject.Inject

class AddTaskActivity : BaseActivity<ActivityAddTaskBinding>() {

    @Inject
    lateinit var addTaskViewModelProvider: AddTaskViewModelProvider
    private val addTaskViewModel by viewModels<AddTaskViewModel> {
        addTaskViewModelProvider
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, AddTaskActivity::class.java)
            context.startActivity(intent)
        }
    }

    override val bindingInflater: (LayoutInflater) -> ActivityAddTaskBinding
        get() = ActivityAddTaskBinding::inflate

    override fun initDependencyInjection() {
        (application as TodoApplication).appComponent
            .getAddTaskComponentFactory()
            .create()
            .inject(this)
    }

    override fun setup() {
        setListeners()
    }

    private fun setListeners() {
        binding.btnSave.setOnClickListener { addTaskViewModel.saveTask() }
    }
}
