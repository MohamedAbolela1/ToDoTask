package com.ibtikar.todolisttask.ui.tasks_list.data

import com.ibtikar.todolisttask.data.local.ToDoDatabase
import com.ibtikar.todolisttask.data.local.dao.TasksDao
import com.ibtikar.todolisttask.ui.tasks_list.domain.TasksListRepository
import javax.inject.Inject

class TasksListRepositoryImpl @Inject constructor(private val taskstDoa: TasksDao) : TasksListRepository {
}