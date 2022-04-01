package ru.diazzerss.example1.di.modules

import dagger.Module
import dagger.Provides
import ru.diazzerss.example1.data.cache.Cache
import ru.diazzerss.example1.data.RepositoryImpl
import ru.diazzerss.example1_api.domain.repository.Repository
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    fun provideRepository(cache: Cache): Repository {
        return RepositoryImpl(cache)
    }
}