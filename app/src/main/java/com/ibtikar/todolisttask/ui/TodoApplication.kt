package com.ibtikar.todolisttask.ui

import android.app.Application
import com.ibtikar.todolisttask.di.AppComponent
import com.ibtikar.todolisttask.di.DaggerAppComponent

class TodoApplication : Application() {
    val appComponent by lazy {
        initAppComponent()
    }

    open fun initAppComponent(): AppComponent {
        return DaggerAppComponent.factory().create(this)
    }
}