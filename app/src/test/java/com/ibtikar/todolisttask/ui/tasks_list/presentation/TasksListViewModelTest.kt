package com.ibtikar.todolisttask.ui.tasks_list.presentation

import com.ibtikar.todolisttask.data.local.model.TaskEntity
import com.ibtikar.todolisttask.ui.base.data.Status
import com.ibtikar.todolisttask.ui.tasks_list.domain.model.TaskItem
import com.ibtikar.todolisttask.ui.tasks_list.domain.repository.TasksListRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class TasksListViewModelTest {

    companion object {
        private const val TASK_TITLE = "task title"
        private const val TASK_BODY = "task body"
        private const val TASK_DATE = 1619154540000L
        private const val TASK_FORMATTED_DATE = "07:09 AM 23/04/2021"
        private const val ERROR_MESSAGE = "No tasks planned"
    }

    @RelaxedMockK
    private lateinit var tasksListRepository: TasksListRepository
    private lateinit var tasksListViewModel: TasksListViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        tasksListViewModel = TasksListViewModel(tasksListRepository)
    }

    @Test
    fun `Given no planned tasks, When getTasksList, Then emit Status_Error`() = runBlockingTest {
        // GIVEN
        every { tasksListRepository.getAllTasks() }.returns(flowOf(emptyList()))

        // WHEN
        val tasksList = tasksListViewModel.getTasksList().first()

        // THEN
        assertEquals(Status.Error(ERROR_MESSAGE), tasksList)
    }

    @Test
    fun `Given no planned tasks, When getTasksList, Then verify getAllTasks invoked once`() =
        runBlockingTest {
            // GIVEN
            every { tasksListRepository.getAllTasks() }.returns(flowOf(emptyList()))

            // WHEN
            tasksListViewModel.getTasksList().first()

            // THEN
            verify(exactly = 1) { tasksListRepository.getAllTasks() }
        }

    @Test
    fun `Given planned tasks, when getTasksList, Then emit Status_Success`() = runBlockingTest {
        // GIVEN
        val taskEntity = TaskEntity(TASK_TITLE, TASK_BODY, TASK_DATE, 1)
        every { tasksListRepository.getAllTasks() }.returns(flowOf(listOf(taskEntity)))

        //WHEN
        val actualValue = tasksListViewModel.getTasksList().first()

        // THEN
        val expectedValue =
            Status.Success(mutableListOf(TaskItem(1, TASK_TITLE, TASK_BODY, TASK_FORMATTED_DATE)))
        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `Given planned tasks, when getTasksList, Then verify getAllTasks invoked`() =
        runBlockingTest {
            // GIVEN
            val taskEntity = TaskEntity(TASK_TITLE, TASK_BODY, TASK_DATE, 1)
            every { tasksListRepository.getAllTasks() }.returns(flowOf(listOf(taskEntity)))

            //WHEN
            tasksListViewModel.getTasksList().first()

            // THEN
            verify(exactly = 1) { tasksListRepository.getAllTasks() }
        }
}