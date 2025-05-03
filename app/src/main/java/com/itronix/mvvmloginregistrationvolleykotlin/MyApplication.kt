package com.itronix.mvvmloginregistrationvolleykotlin

import android.app.Application
import android.content.Context

class MyApplication : Application() {

    companion object {
        private var instance: MyApplication? = null

        fun getAppContext(): Context {
            return instance?.applicationContext
                ?: throw IllegalStateException("Application not initialized!")
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}