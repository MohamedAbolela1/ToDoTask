package com.ibtikar.todolisttask.ui.tasks_list.domain.model

import com.ibtikar.todolisttask.data.local.model.TaskEntity
import com.ibtikar.todolisttask.utils.date.DateFormat
import java.util.*

data class TaskItem(
    val id: Int,
    val title: String?,
    val body: String?,
    val date: String?
)

fun List<TaskEntity>.toTaskItem(): MutableList<TaskItem> {
    return this.map {
        val date =
            DateFormat.formatDateToString(Date(it.date), DateFormat.FORMAT_EEE_MMM_DD_YYYY_H_MM_SS)
        TaskItem(it.id, it.title, it.body, date)
    }.toMutableList()
}