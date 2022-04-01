package ru.diazzerss.example2.di.components

import dagger.Subcomponent
import ru.diazzerss.example2.di.modules.*
import ru.diazzerss.example2.presentation.view.Example2
import ru.diazzerss.presentation.base.BaseDaggerComponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [ViewModelModule::class, DomainModule::class, DataModule::class, RemoteModule::class, CacheModule::class])
interface Example2Component : BaseDaggerComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(cacheModule: CacheModule): Example2Component
    }

    fun inject(fragment: Example2)
}