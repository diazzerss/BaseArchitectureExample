package ru.diazzerss.basearchitectureexample

import ru.diazzerss.basearchitectureexample.di.components.AppComponent
import ru.diazzerss.basearchitectureexample.di.components.DaggerAppComponent
import ru.diazzerss.example1.di.components.Example1Component
import ru.diazzerss.example2.di.components.Example2Component
import ru.diazzerss.example2.di.modules.CacheModule as Example2CacheModule
import ru.diazzerss.example1.di.modules.CacheModule as Example1CacheModule
import ru.diazzerss.presentation.base.BaseApplication
import ru.diazzerss.presentation.base.BaseDaggerComponent
import ru.diazzerss.recycler_view_example.di.components.RecyclerViewExampleComponent
import ru.diazzerss.recycler_view_example.di.modules.CacheModule as RecyclerViewExampleCacheModule
import java.lang.IllegalArgumentException

class App : BaseApplication() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.create()
    }

    override fun provideComponent(type: Class<out BaseDaggerComponent>): BaseDaggerComponent {
        return when(type) {
            Example1Component::class.java -> appComponent.createExample1Component().create(Example1CacheModule(this))
            Example2Component::class.java -> appComponent.createExample2Component().create(Example2CacheModule(this))
            RecyclerViewExampleComponent::class.java -> appComponent.createRecyclerViewExampleComponent().create(RecyclerViewExampleCacheModule(this))
            else -> throw IllegalArgumentException("Dagger component not provided: $type")
        }
    }
}