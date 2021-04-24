package com.ibtikar.todolisttask.ui.add_task.data

import com.ibtikar.todolisttask.data.local.dao.TasksDao
import com.ibtikar.todolisttask.data.local.model.TaskEntity
import com.ibtikar.todolisttask.ui.add_task.domain.repository.AddTaskRepository
import javax.inject.Inject

class AddTaskRepositoryImpl @Inject constructor(
    private val tasksDoa: TasksDao
) : AddTaskRepository {
    override suspend fun saveTask(taskTitle: String, taskDescription: String, date: Long) {
        tasksDoa.addTask(TaskEntity(title = taskTitle, body = taskDescription, date = date))
    }
}
