package com.ibtikar.todolisttask.ui.add_task.presentation

import com.ibtikar.todolisttask.ui.add_task.domain.repository.AddTaskRepository
import com.ibtikar.todolisttask.ui.base.data.Status
import com.ibtikar.todolisttask.ui.base.presentation.BaseViewModel
import com.ibtikar.todolisttask.utils.date.DateFormat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.util.*

class AddTaskViewModel(private val addTaskRepository: AddTaskRepository) : BaseViewModel() {

    private var selectedDate: Date? = null

    suspend fun saveTask(
        taskTitle: String?,
        taskDescription: String?
    ): Flow<Status<Unit>> {
        val taskDataValid = validateTaskData(taskTitle, taskDescription)
        return if (taskDataValid) {
            addTaskRepository.saveTask(taskTitle!!, taskDescription!!, selectedDate!!.time)
            flowOf(Status.Success(Unit))
        } else {
            flowOf(Status.Error("Please fill the fields with valid data"))
        }
    }

    private fun validateTaskData(taskTitle: String?, taskDescription: String?): Boolean {
        return !taskTitle.isNullOrBlank() && !taskDescription.isNullOrBlank() && selectedDate != null
    }

    fun onDateSelected(date: Date): String? {
        this.selectedDate = date
        return DateFormat.formatDateToString(date, DateFormat.FORMAT_EEE_MMM_DD_YYYY_H_MM_SS)
    }
}
