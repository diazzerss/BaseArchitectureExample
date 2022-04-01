package ru.diazzerss.recycler_view_example.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.diazzerss.presentation.annotations.ViewModelKey
import ru.diazzerss.presentation.factories.ViewModelFactory
import ru.diazzerss.recycler_view_example.presentation.view_model.RecyclerViewExampleViewModel

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(RecyclerViewExampleViewModel::class)
    abstract fun bindRecyclerViewExampleViewModel(recyclerViewExampleViewModel: RecyclerViewExampleViewModel): ViewModel
}