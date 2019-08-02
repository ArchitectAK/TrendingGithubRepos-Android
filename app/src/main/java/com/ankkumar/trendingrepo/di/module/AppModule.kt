package com.ankkumar.trendingrepo.di.module

import android.content.Context
import com.ankkumar.trendingrepo.TreendingRepoApplication
import com.ankkumar.trendingrepo.di.builder.ViewModelModule
import com.ankkumar.trendingrepo.retrofit.APIService
import com.ankkumar.trendingrepo.room.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [ViewModelModule::class, NetworkModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideAppContext(application: TreendingRepoApplication): Context {
        return application.applicationContext

    }


    @Provides
    @Singleton
    fun provideRepository(apiService: APIService, database: AppDatabase): Repository {
        return Repository(apiService, database)
    }
}
