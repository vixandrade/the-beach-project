package xyz.vixandrade.thebeachproject.di.component

import dagger.Component
import xyz.vixandrade.thebeachproject.ApplicationClass
import xyz.vixandrade.thebeachproject.di.module.AppModule
import xyz.vixandrade.thebeachproject.di.module.NetworkModule
import xyz.vixandrade.thebeachproject.ui.beaches.BeachesPresenterImpl

@Component(modules = [AppModule::class, NetworkModule::class])
interface ApplicationComponent {

    fun inject(mApplicationClass: ApplicationClass)
    fun inject(mBeachesPresenterImpl: BeachesPresenterImpl)

}