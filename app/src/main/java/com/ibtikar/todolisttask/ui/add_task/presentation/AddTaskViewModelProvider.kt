package com.ibtikar.todolisttask.ui.add_task.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ibtikar.todolisttask.ui.add_task.domain.repository.AddTaskRepository
import javax.inject.Inject

class AddTaskViewModelProvider @Inject constructor(
    private val addTaskRepository: AddTaskRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddTaskViewModel(addTaskRepository) as T
    }
}
