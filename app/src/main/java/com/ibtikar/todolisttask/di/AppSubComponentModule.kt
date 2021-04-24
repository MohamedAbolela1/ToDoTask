package com.ibtikar.todolisttask.di

import com.ibtikar.todolisttask.ui.add_task.di.AddTaskComponent
import com.ibtikar.todolisttask.ui.tasks_list.di.TasksListComponent
import dagger.Module

@Module(subcomponents = [TasksListComponent::class, AddTaskComponent::class])
class AppSubComponentModule
