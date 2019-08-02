package com.ankkumar.trendingrepo.di.builder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ankkumar.trendingrepo.di.ViewModelFactory
import com.ankkumar.trendingrepo.di.ViewModelKey
import com.ankkumar.trendingrepo.ui.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Provider

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun providesViewModelFactory(creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>): ViewModelProvider.Factory {
            return ViewModelFactory(creators)
        }
    }


}