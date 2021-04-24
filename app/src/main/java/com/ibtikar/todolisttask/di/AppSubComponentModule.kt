package com.ibtikar.todolisttask.di

import com.ibtikar.todolisttask.ui.tasks_list.di.TasksListComponent
import dagger.Module

@Module(subcomponents = [TasksListComponent::class])
class AppSubComponentModule