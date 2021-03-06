package com.ibtikar.todolisttask.ui.tasks_list.data

import com.ibtikar.todolisttask.data.local.dao.TasksDao
import com.ibtikar.todolisttask.data.local.model.TaskEntity
import com.ibtikar.todolisttask.ui.tasks_list.domain.repository.TasksListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TasksListRepositoryImpl @Inject constructor(private val tasksDoa: TasksDao) :
    TasksListRepository {
    override fun getAllTasks(): Flow<List<TaskEntity>> {
        return tasksDoa.getTasksList()
    }
}
