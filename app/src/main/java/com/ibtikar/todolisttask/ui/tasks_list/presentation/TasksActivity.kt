package com.ibtikar.todolisttask.ui.tasks_list.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ibtikar.todolisttask.databinding.ActivityTasksBinding
import com.ibtikar.todolisttask.ui.TodoApplication
import javax.inject.Inject

class TasksActivity : AppCompatActivity() {

    @Inject
    lateinit var tasksListViewModelProvider: TasksListViewModelProvider

    private lateinit var tasksListViewModel: TasksListViewModel

    private lateinit var binding: ActivityTasksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        initDependencyInjection()
        super.onCreate(savedInstanceState)
        binding = ActivityTasksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
    }

    private fun initDependencyInjection() {
        (application as TodoApplication).appComponent
            .getTasksListComponentFactory()
            .create()
            .inject(this)
    }

    private fun initViewModel() {
        tasksListViewModel =
            ViewModelProvider(this, tasksListViewModelProvider)
                .get(TasksListViewModel::class.java)
    }
}
