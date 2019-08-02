package com.ankkumar.trendingrepo.di.builder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ankkumar.trendingrepo.di.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
abstract class ViewModelModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun providesViewModelFactory(creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>): ViewModelProvider.Factory {
            return ViewModelFactory(creators)
        }
    }


}