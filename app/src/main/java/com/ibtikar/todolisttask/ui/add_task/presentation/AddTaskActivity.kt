package com.ibtikar.todolisttask.ui.add_task.presentation

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.ibtikar.todolisttask.databinding.ActivityAddTaskBinding
import com.ibtikar.todolisttask.ui.TodoApplication
import com.ibtikar.todolisttask.ui.base.data.Status
import com.ibtikar.todolisttask.ui.base.presentation.BaseActivity
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*
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
        binding.btnSave.setOnClickListener { onBtnSaveClicked() }
    }

    private fun onBtnSaveClicked() {
        with(binding) {
            lifecycleScope.launch {
                addTaskViewModel.saveTask(
                    etToDoTitle.text?.toString(),
                    etToDoDescription.text?.toString(),
                    Date()
                ).collect { onSaveTaskStateRetrieved(it) }
            }
        }
    }

    private fun onSaveTaskStateRetrieved(status: Status<Unit>) {
        when (status) {
            is Status.Success -> finish()
            is Status.Error -> Toast.makeText(this, status.message, Toast.LENGTH_SHORT).show()
        }
    }
}
