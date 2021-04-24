package com.ibtikar.todolisttask.ui.add_task.di

import com.ibtikar.todolisttask.ui.add_task.presentation.AddTaskActivity
import dagger.Subcomponent

@Subcomponent(modules = [AddTaskModule::class])
interface AddTaskComponent {
    fun inject(addTaskActivity: AddTaskActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): AddTaskComponent
    }
}
