package xyz.vixandrade.thebeachproject.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import xyz.vixandrade.thebeachproject.network.IBeachesApi
import xyz.vixandrade.thebeachproject.utils.Constants

@Module
class NetworkModule {

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun provideBeachesApi(gson: Gson): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Constants.BEACH_ENDPOINT_URL)
                .build()
    }

    @Provides
    fun provideBeachesService(beachesApi: Retrofit): IBeachesApi {
        return beachesApi.create(IBeachesApi::class.java)
    }
}