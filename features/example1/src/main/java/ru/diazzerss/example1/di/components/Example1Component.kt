package ru.diazzerss.example1.di.components

import dagger.Subcomponent
import ru.diazzerss.example1.di.modules.CacheModule
import ru.diazzerss.example1.di.modules.DataModule
import ru.diazzerss.example1.di.modules.DomainModule
import ru.diazzerss.example1.di.modules.ViewModelModule
import ru.diazzerss.example1.presentation.view.Example1
import ru.diazzerss.presentation.base.BaseDaggerComponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [ViewModelModule::class, DomainModule::class, DataModule::class, CacheModule::class])
interface Example1Component : BaseDaggerComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(cacheModule: CacheModule): Example1Component
    }

    fun inject(fragment: Example1)
}