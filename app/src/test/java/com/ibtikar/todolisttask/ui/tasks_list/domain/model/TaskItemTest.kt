package com.ibtikar.todolisttask.ui.tasks_list.domain.model

import com.ibtikar.todolisttask.data.local.model.TaskEntity
import org.junit.Assert.*
import org.junit.Test

class TaskItemTest {
    companion object {
        private const val TASK_TITLE = "task title"
        private const val TASK_BODY = "task body"
        private const val TASK_DATE = 1619154540000L
        private const val TASK_FORMATTED_DATE = "07:09 AM 23/04/2021"
    }

    @Test
    fun `Given Task Entity List, When toTaskItem, Then map to TaskItem`() {
        // GIVEN
        val taskEntity = listOf(TaskEntity(TASK_TITLE, TASK_BODY, TASK_DATE, 1))

        // WHEN
        val actualValue = taskEntity.toTaskItem()
        val expectedValue = mutableListOf(TaskItem(1, TASK_TITLE, TASK_BODY, TASK_FORMATTED_DATE))

        // THEN
        assertEquals(expectedValue, actualValue)
    }
}