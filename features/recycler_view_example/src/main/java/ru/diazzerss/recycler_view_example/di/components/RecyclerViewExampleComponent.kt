package ru.diazzerss.recycler_view_example.di.components

import dagger.Subcomponent
import ru.diazzerss.presentation.base.BaseDaggerComponent
import ru.diazzerss.recycler_view_example.di.modules.*
import ru.diazzerss.recycler_view_example.presentation.view.RecyclerViewExample
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [ViewModelModule::class, DomainModule::class, DataModule::class, RemoteModule::class, CacheModule::class])
interface RecyclerViewExampleComponent : BaseDaggerComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(cacheModule: CacheModule): RecyclerViewExampleComponent
    }

    fun inject(recyclerViewExample: RecyclerViewExample)
}