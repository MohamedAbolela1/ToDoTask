package com.ibtikar.todolisttask.ui.tasks_list.presentation

import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibtikar.todolisttask.databinding.ActivityTasksBinding
import com.ibtikar.todolisttask.ui.TodoApplication
import com.ibtikar.todolisttask.ui.add_task.presentation.AddTaskActivity
import com.ibtikar.todolisttask.ui.base.data.Status
import com.ibtikar.todolisttask.ui.base.presentation.BaseActivity
import com.ibtikar.todolisttask.ui.tasks_list.domain.model.TaskItem
import com.ibtikar.todolisttask.ui.tasks_list.presentation.adapter.TasksAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class TasksActivity : BaseActivity<ActivityTasksBinding>() {

    @Inject
    lateinit var tasksListViewModelProvider: TasksListViewModelProvider

    private val tasksAdapter: TasksAdapter by lazy {
        TasksAdapter(this)
    }

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
        initViews()
        initViewModel()
        setListeners()
    }

    private fun initViews() {
        with(binding) {
            rvTasks.layoutManager = LinearLayoutManager(applicationContext)
            rvTasks.adapter = tasksAdapter
        }
    }

    private fun setListeners() {
        binding.btnAddTask.setOnClickListener {
            AddTaskActivity.start(this)
        }
    }

    private fun initViewModel() {
        tasksListViewModel.getTasksList()
            .onEach(::onTasksListStateRetrieved)
            .launchIn(lifecycleScope)
    }

    private fun onTasksListStateRetrieved(status: Status<MutableList<TaskItem>>) {
        when (status) {
            is Status.Success -> tasksAdapter.insertAll(status.data)
            is Status.Error -> Log.e("xxx", "onTasksListStateRetrieved:${status.message} ")
        }
    }

}
