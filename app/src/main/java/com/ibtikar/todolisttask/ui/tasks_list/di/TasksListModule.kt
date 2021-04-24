package com.ibtikar.todolisttask.ui.tasks_list.di

import com.ibtikar.todolisttask.ui.tasks_list.data.TasksListRepositoryImpl
import com.ibtikar.todolisttask.ui.tasks_list.domain.TasksListRepository
import dagger.Binds
import dagger.Module

@Module
abstract class TasksListModule {
    @Binds
    abstract fun providesTasksListRepository(tasksListRepository: TasksListRepositoryImpl):
            TasksListRepository
}