package ru.diazzerss.basearchitectureexample.di.components

import dagger.Component
import ru.diazzerss.example1.di.components.Example1Component
import ru.diazzerss.example2.di.components.Example2Component
import ru.diazzerss.recycler_view_example.di.components.RecyclerViewExampleComponent

@Component
interface AppComponent {
    fun createExample1Component(): Example1Component.Factory
    fun createExample2Component(): Example2Component.Factory
    fun createRecyclerViewExampleComponent(): RecyclerViewExampleComponent.Factory
}