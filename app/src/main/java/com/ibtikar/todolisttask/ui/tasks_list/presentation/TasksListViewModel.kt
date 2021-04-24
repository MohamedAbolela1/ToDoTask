package com.ibtikar.todolisttask.ui.tasks_list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibtikar.todolisttask.data.local.model.TaskEntity
import com.ibtikar.todolisttask.ui.base.data.Status
import com.ibtikar.todolisttask.ui.tasks_list.domain.model.TaskItem
import com.ibtikar.todolisttask.ui.tasks_list.domain.model.toTaskItem
import com.ibtikar.todolisttask.ui.tasks_list.domain.repository.TasksListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

class TasksListViewModel(private val tasksListRepository: TasksListRepository) : ViewModel() {
    fun getTasksList(): Flow<Status<MutableList<TaskItem>>> {
        return tasksListRepository.getAllTasks()
            .map(::mapTasksList)
    }

    private fun mapTasksList(tasksList: List<TaskEntity>): Status<MutableList<TaskItem>> {
        return if (tasksList.isNullOrEmpty()) {
            Status.Error("No tasks planned")
        } else {
            Status.Success(tasksList.toTaskItem())
        }
    }
}
