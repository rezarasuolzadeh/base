package ir.rezarasuolzadeh.base

import android.app.Application
import ir.rezarasuolzadeh.base.di.appModule
import ir.rezarasuolzadeh.base.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeKoin()
    }

    /**
     * config and initialize the koin dependency injection.
     */
    private fun initializeKoin() = startKoin {
        androidContext(androidContext = this@Application)
        modules(modules = listOf(appModule, viewModelModule))
    }

}