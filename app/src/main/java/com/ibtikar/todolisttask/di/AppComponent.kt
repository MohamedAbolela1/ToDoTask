package com.ibtikar.todolisttask.di

import android.content.Context
import com.ibtikar.todolisttask.ui.add_task.di.AddTaskComponent
import com.ibtikar.todolisttask.ui.tasks_list.di.TasksListComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TasksModule::class, AppSubComponentModule::class])
interface AppComponent {

    fun getTasksListComponentFactory(): TasksListComponent.Factory
    fun getAddTaskComponentFactory(): AddTaskComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}