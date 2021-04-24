package com.ibtikar.todolisttask.ui.add_task.presentation

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import com.ibtikar.todolisttask.databinding.ActivityAddTaskBinding
import com.ibtikar.todolisttask.ui.base.BaseActivity

class AddTaskActivity : BaseActivity<ActivityAddTaskBinding>() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, AddTaskActivity::class.java)
            context.startActivity(intent)
        }
    }

    override val bindingInflater: (LayoutInflater) -> ActivityAddTaskBinding
        get() = ActivityAddTaskBinding::inflate

    override fun initDependencyInjection() {
    }

    override fun setup() {
    }
}
