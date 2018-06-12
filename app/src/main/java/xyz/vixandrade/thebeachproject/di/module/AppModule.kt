package xyz.vixandrade.thebeachproject.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(application: Application) {

    var applicationInst: Application = application

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return applicationInst
    }
}