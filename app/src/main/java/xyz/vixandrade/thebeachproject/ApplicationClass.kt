package xyz.vixandrade.thebeachproject

import android.app.Application
import xyz.vixandrade.thebeachproject.di.component.ApplicationComponent
import xyz.vixandrade.thebeachproject.di.component.DaggerApplicationComponent
import xyz.vixandrade.thebeachproject.di.module.AppModule
import xyz.vixandrade.thebeachproject.di.module.NetworkModule

open class ApplicationClass: Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent
                .builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .build()

        applicationComponent.inject(this)
    }
}