package com.ibtikar.todolisttask.ui.tasks_list.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ibtikar.todolisttask.databinding.ItemTaskBinding
import com.ibtikar.todolisttask.ui.base.presentation.BaseAdapter
import com.ibtikar.todolisttask.ui.base.presentation.BaseViewHolder
import com.ibtikar.todolisttask.ui.tasks_list.domain.model.TaskItem

class TasksAdapter(private val context: Context) :
    BaseAdapter<TaskItem>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<TaskItem> {
        val taskBinding = ItemTaskBinding.inflate(LayoutInflater.from(context), parent, false)
        return TasksViewHolder(taskBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<TaskItem>, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int = data.size

}