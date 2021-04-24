package com.ibtikar.todolisttask.ui.tasks_list.di

import com.ibtikar.todolisttask.ui.tasks_list.presentation.TasksActivity
import dagger.Subcomponent

@Subcomponent(modules = [TasksListModule::class])
interface TasksListComponent {

    fun inject(tasksActivity: TasksActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TasksListComponent
    }
}
