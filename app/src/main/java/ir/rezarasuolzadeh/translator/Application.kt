package ir.rezarasuolzadeh.translator

import android.app.Application
import com.orhanobut.hawk.Hawk
import ir.rezarasuolzadeh.translator.di.HttpModule
import ir.rezarasuolzadeh.translator.di.ViewModelModule
import ir.rezarasuolzadeh.translator.di.WebserviceModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeKoin()
        initializeHawk()
    }

    /**
     * config and initialize the koin dependency injection.
     */
    private fun initializeKoin() = startKoin {
        androidContext(androidContext = this@Application)
        modules(modules = listOf(HttpModule, ViewModelModule, WebserviceModule))
    }

    /**
     * config and initialize the Hawk.
     */
    private fun initializeHawk() {
        Hawk.init(applicationContext).build()
    }

}