package com.ibtikar.todolisttask.ui.tasks_list.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibtikar.todolisttask.ui.tasks_list.domain.TasksListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class TasksListViewModel(private val tasksListRepository: TasksListRepository) : ViewModel() {
    fun getTasksList() {
        viewModelScope.launch {
            tasksListRepository.getAllTasks()
                .flowOn(Dispatchers.IO)
                .collect {
                    Log.e("xxx", "getTasksList: $it")
                }
        }
    }
}
