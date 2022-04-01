package ru.diazzerss.example2.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.diazzerss.example2.presentation.view_model.Example2ViewModel
import ru.diazzerss.presentation.annotations.ViewModelKey
import ru.diazzerss.presentation.factories.ViewModelFactory

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModuleFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(Example2ViewModel::class)
    abstract fun bindExample2ViewModule(model: Example2ViewModel): ViewModel
}