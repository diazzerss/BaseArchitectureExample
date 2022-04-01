package ru.diazzerss.example2.di.modules

import dagger.Module
import dagger.Provides
import ru.diazzerss.example2.data.remote.Remote
import ru.diazzerss.example2.data.RepositoryImpl
import ru.diazzerss.example2_api.domain.repository.Repository
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideRepository(remote: Remote): Repository {
        return RepositoryImpl(remote)
    }
}