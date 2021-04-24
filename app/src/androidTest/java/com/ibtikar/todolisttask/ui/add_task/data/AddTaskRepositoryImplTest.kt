package com.ibtikar.todolisttask.ui.add_task.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ibtikar.todolisttask.data.local.ToDoDatabase
import com.ibtikar.todolisttask.data.local.dao.TasksDao
import com.ibtikar.todolisttask.data.local.model.TaskEntity
import com.ibtikar.todolisttask.ui.add_task.domain.repository.AddTaskRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AddTaskRepositoryImplTest {
    companion object {
        private const val TASK_TITLE = "task title"
        private const val TASK_BODY = "task body"
        private const val TASK_DATE = 1619154540L
        private const val TASK_ID = 1
    }

    private lateinit var tasksDao: TasksDao
    private lateinit var tasksDataBase: ToDoDatabase
    private lateinit var addTaskRepository: AddTaskRepository

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        tasksDataBase = Room.inMemoryDatabaseBuilder(context, ToDoDatabase::class.java).build()
        tasksDao = tasksDataBase.taskDao()
        addTaskRepository = AddTaskRepositoryImpl(tasksDao)
    }

    @Test
    fun validateTasksAddedSuccessfully() = runBlocking {
        // WHEN
        addTaskRepository.saveTask(TASK_TITLE, TASK_BODY, TASK_DATE)

        // THEN
        val tasksList = tasksDao.getTasksList().first()
        val expectedTasksList = listOf(TaskEntity(TASK_TITLE, TASK_BODY, TASK_DATE, TASK_ID))
        Assert.assertEquals(expectedTasksList, tasksList)
    }
}