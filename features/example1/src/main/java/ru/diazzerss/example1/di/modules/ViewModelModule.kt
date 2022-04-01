package ru.diazzerss.example1.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.diazzerss.presentation.annotations.ViewModelKey
import ru.diazzerss.example1.presentation.view_model.Example1ViewModel
import ru.diazzerss.presentation.factories.ViewModelFactory

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(Example1ViewModel::class)
    abstract fun bindExample1ViewModel(example1ViewModel: Example1ViewModel): ViewModel
}