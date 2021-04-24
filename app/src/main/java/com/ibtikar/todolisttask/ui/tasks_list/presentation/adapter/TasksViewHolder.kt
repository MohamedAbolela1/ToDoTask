package com.ibtikar.todolisttask.ui.tasks_list.presentation.adapter

import com.ibtikar.todolisttask.databinding.ItemTaskBinding
import com.ibtikar.todolisttask.ui.base.presentation.BaseViewHolder
import com.ibtikar.todolisttask.ui.tasks_list.domain.model.TaskItem

class TasksViewHolder(private val taskBinding: ItemTaskBinding) :
    BaseViewHolder<TaskItem>(taskBinding.root) {
    override fun onBind(item: TaskItem) {
        with(taskBinding) {
            tvTaskTitle.text = item.title
            tvTaskBody.text = item.body
            tvDate.text = item.date
        }
    }

}