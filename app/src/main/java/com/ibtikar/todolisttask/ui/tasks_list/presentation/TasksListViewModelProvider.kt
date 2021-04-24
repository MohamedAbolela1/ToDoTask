package com.ibtikar.todolisttask.ui.tasks_list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ibtikar.todolisttask.ui.tasks_list.domain.repository.TasksListRepository
import javax.inject.Inject

class TasksListViewModelProvider @Inject constructor(
    private val tasksListRepository: TasksListRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TasksListViewModel(tasksListRepository) as T
    }
}