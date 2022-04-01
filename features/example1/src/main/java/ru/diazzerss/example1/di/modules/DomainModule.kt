package ru.diazzerss.example1.di.modules

import dagger.Module
import dagger.Provides
import ru.diazzerss.example1_api.domain.interactor.GetDataFromCache
import ru.diazzerss.example1_api.domain.repository.Repository

@Module
class DomainModule {

    @Provides
    fun provideGetDataFromCache(repository: Repository): GetDataFromCache {
        return GetDataFromCache(repository)
    }
}