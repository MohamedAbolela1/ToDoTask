package com.ibtikar.todolisttask.ui.add_task.presentation

import com.ibtikar.todolisttask.ui.add_task.domain.repository.AddTaskRepository
import com.ibtikar.todolisttask.ui.base.data.Status
import com.ibtikar.todolisttask.ui.base.presentation.BaseViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.util.*

class AddTaskViewModel(private val addTaskRepository: AddTaskRepository) : BaseViewModel() {

    suspend fun saveTask(taskTitle: String?, taskDescription: String?, date: Date?): Flow<Status<Unit>> {
        val taskDataValid = validateTaskData(taskTitle, taskDescription, date)
        return if (taskDataValid) {
            addTaskRepository.saveTask(taskTitle!!, taskDescription!!, date!!.time)
            flowOf(Status.Success(Unit))
        } else {
            flowOf(Status.Error("Please fill the fields with valid data"))
        }
    }

    private fun validateTaskData(
        taskTitle: String?,
        taskDescription: String?,
        date: Date?
    ): Boolean {
        return !taskTitle.isNullOrBlank() && !taskDescription.isNullOrBlank() && date != null
    }
}
