package com.ankkumar.trendingrepo

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class TreendingRepoApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

}