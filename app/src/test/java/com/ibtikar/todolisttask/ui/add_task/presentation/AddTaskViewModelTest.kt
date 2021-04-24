package com.ibtikar.todolisttask.ui.add_task.presentation

import com.ibtikar.todolisttask.ui.add_task.domain.repository.AddTaskRepository
import com.ibtikar.todolisttask.ui.base.data.Status
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test


@ExperimentalCoroutinesApi
class AddTaskViewModelTest {

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
        Assert.assertEquals(Status.Error("Please fill the fields with valid data"), actualValue)
    }


}