package com.ibtikar.todolisttask.ui.add_task.data

import com.ibtikar.todolisttask.data.local.dao.TasksDao
import com.ibtikar.todolisttask.ui.add_task.domain.repository.AddTaskRepository
import javax.inject.Inject

class AddTaskRepositoryImpl @Inject constructor(
    private val tasksDoa: TasksDao
) : AddTaskRepository
