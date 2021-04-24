package com.ibtikar.todolisttask.ui.tasks_list.presentation

import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ibtikar.todolisttask.databinding.ActivityTasksBinding
import com.ibtikar.todolisttask.ui.TodoApplication
import com.ibtikar.todolisttask.ui.add_task.presentation.AddTaskActivity
import com.ibtikar.todolisttask.ui.base.presentation.BaseActivity
import javax.inject.Inject

class TasksActivity : BaseActivity<ActivityTasksBinding>() {

    @Inject
    lateinit var tasksListViewModelProvider: TasksListViewModelProvider

    private val tasksListViewModel by viewModels<TasksListViewModel>() {
        tasksListViewModelProvider
    }

    override val bindingInflater: (LayoutInflater) -> ActivityTasksBinding
        get() = ActivityTasksBinding::inflate

    override fun initDependencyInjection() {
        (application as TodoApplication).appComponent
            .getTasksListComponentFactory()
            .create()
            .inject(this)
    }

    override fun setup() {
        initViewModel()
        setListeners()
    }

    private fun initViewModel() {
        tasksListViewModel.getTasksList()
    }

    private fun setListeners() {
        binding.btnAddTask.setOnClickListener {
            AddTaskActivity.start(this)
        }
    }
}
