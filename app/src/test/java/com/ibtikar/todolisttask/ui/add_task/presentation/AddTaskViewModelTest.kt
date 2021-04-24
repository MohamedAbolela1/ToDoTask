package com.ibtikar.todolisttask.ui.add_task.presentation

import com.ibtikar.todolisttask.ui.add_task.domain.repository.AddTaskRepository
import com.ibtikar.todolisttask.ui.base.data.Status
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.util.*


@ExperimentalCoroutinesApi
class AddTaskViewModelTest {

    companion object {
        private const val TASK_TITLE = "task title"
        private const val TASK_BODY = "task body"
        private const val TASK_DATE = 1619154540L
        private const val TASK_ERROR_MESSAGE = "Please fill the fields with valid data"
    }

    @RelaxedMockK
    private lateinit var addTaskRepository: AddTaskRepository
    private lateinit var addTaskViewModel: AddTaskViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        addTaskViewModel = AddTaskViewModel(addTaskRepository)
    }

    @Test
    fun `Given invalid task data, When saveTask, Then emit Status_Error`() = runBlockingTest {
        // WHEN
        val saveTask = addTaskViewModel.saveTask(null, "")

        // THEN
        val actualValue = saveTask.first()
        assertEquals(Status.Error(TASK_ERROR_MESSAGE), actualValue)
    }

    @Test
    fun `Given valid task data, When saveTask, Then emit Status_Success`() = runBlockingTest {
        // GIVEN
        addTaskViewModel.onDateSelected(Date(TASK_DATE))

        // WHEN
        val actualValue = addTaskViewModel.saveTask(TASK_TITLE, TASK_BODY).first()

        // THEN
        assertEquals(Status.Success(Unit), actualValue)
    }

}