package com.ibtikar.todolisttask.ui.base.data

sealed class Status<out T> {
    data class Success<T>(val data: T) : Status<T>()
    data class Error(val message: String) : Status<Nothing>()
}
