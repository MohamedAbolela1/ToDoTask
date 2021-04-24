package com.ibtikar.todolisttask.ui.add_task.domain.repository

interface AddTaskRepository {
    suspend fun saveTask(taskTitle: String, taskDescription: String, time: Long)
}
