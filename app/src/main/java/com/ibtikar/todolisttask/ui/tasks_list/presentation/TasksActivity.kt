package com.ibtikar.todolisttask.ui.tasks_list.presentation

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.ibtikar.todolisttask.databinding.ActivityTasksBinding
import com.ibtikar.todolisttask.ui.TodoApplication
import com.ibtikar.todolisttask.ui.base.BaseActivity
import javax.inject.Inject

class TasksActivity : BaseActivity<ActivityTasksBinding>() {

    @Inject
    lateinit var tasksListViewModelProvider: TasksListViewModelProvider

    private lateinit var tasksListViewModel: TasksListViewModel

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
    }

    private fun initViewModel() {
        tasksListViewModel =
            ViewModelProvider(this, tasksListViewModelProvider)
                .get(TasksListViewModel::class.java)
    }
}
