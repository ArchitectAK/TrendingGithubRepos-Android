package com.ankkumar.trendingrepo.di.builder

import com.ankkumar.trendingrepo.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}