package com.ibtikar.todolisttask.ui.add_task.di

import com.ibtikar.todolisttask.ui.add_task.data.AddTaskRepositoryImpl
import com.ibtikar.todolisttask.ui.add_task.domain.repository.AddTaskRepository
import dagger.Binds
import dagger.Module

@Module
abstract class AddTaskModule {
    @Binds
    abstract fun providesAddTaskRepository(addTaskRepositoryImpl: AddTaskRepositoryImpl):
        AddTaskRepository
}
