package ru.diazzerss.recycler_view_example.di.modules

import dagger.Module
import dagger.Provides
import ru.diazzerss.recycler_view_example.data.network.Remote
import ru.diazzerss.recycler_view_example.data.RepositoryImpl
import ru.diazzerss.recycler_view_example_api.domain.repository.Repository
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideRepository(remote: Remote): Repository = RepositoryImpl(remote)
}