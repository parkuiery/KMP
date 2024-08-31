package org.uiel.todos

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.uiel.todos.di.appModule
import org.uiel.todos.di.initKoin

class TodosApp: Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }
}