package ru.diazzerss.example2.di.modules

import dagger.Module
import dagger.Provides
import ru.diazzerss.example2_api.domain.interactor.GetDataFromServer
import ru.diazzerss.example2_api.domain.repository.Repository

@Module
class DomainModule {

    @Provides
    fun provideGetDataFromServer(repository: Repository): GetDataFromServer {
        return GetDataFromServer(repository)
    }
}