package ru.diazzerss.recycler_view_example.di.modules

import dagger.Module
import dagger.Provides
import ru.diazzerss.recycler_view_example_api.domain.interactor.LoadData
import ru.diazzerss.recycler_view_example_api.domain.repository.Repository

@Module
class DomainModule {

    @Provides
    fun provideLoadData(repository: Repository): LoadData = LoadData(repository)
}