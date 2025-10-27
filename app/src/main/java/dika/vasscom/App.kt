package dika.vasscom

import android.app.Application
import dika.vasscom.di.LocalDataModule
import dika.vasscom.di.RepositoryModule
import dika.vasscom.di.ServiceModule
import dika.vasscom.di.UseCaseModule
import dika.vasscom.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            allModules()
        }
    }

    companion object {
        fun KoinApplication.allModules() = modules(
            ServiceModule.get(),
            RepositoryModule.get(),
            UseCaseModule.get(),
            ViewModelModule.get(),
            LocalDataModule.get()
        )
    }
}