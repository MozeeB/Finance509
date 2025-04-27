package com.finance.tracker

import android.app.Application
import com.finance.tracker.di.initKoin
import org.koin.android.ext.koin.androidContext

class FinanceApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@FinanceApp)
        }
    }
}