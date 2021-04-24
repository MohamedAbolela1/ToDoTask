package com.ibtikar.todolisttask.di

import android.content.Context
import androidx.room.Room
import com.ibtikar.todolisttask.data.local.ToDoDatabase
import com.ibtikar.todolisttask.data.local.dao.TasksDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class TasksModule {

    @Singleton
    @Provides
    fun todoDataBase(context: Context): ToDoDatabase {
        return Room.databaseBuilder(context, ToDoDatabase::class.java, "ToDoDatabase.db").build()
    }

    @Singleton
    @Provides
    fun providesProductDao(toDoDatabase: ToDoDatabase): TasksDao {
        return toDoDatabase.taskDao()
    }
}
