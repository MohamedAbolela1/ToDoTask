package com.ibtikar.todolisttask.ui.tasks_list.domain.repository

import com.ibtikar.todolisttask.data.local.model.TaskEntity
import kotlinx.coroutines.flow.Flow

interface TasksListRepository {
    fun getAllTasks(): Flow<List<TaskEntity>>
}
