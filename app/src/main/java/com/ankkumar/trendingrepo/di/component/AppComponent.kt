package com.ankkumar.trendingrepo.di.component

import com.ankkumar.trendingrepo.TrendingRepoApplication
import com.ankkumar.trendingrepo.di.builder.ActivityBindingModule
import com.ankkumar.trendingrepo.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivityBindingModule::class])
interface AppComponent : AndroidInjector<TrendingRepoApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<TrendingRepoApplication>()

}