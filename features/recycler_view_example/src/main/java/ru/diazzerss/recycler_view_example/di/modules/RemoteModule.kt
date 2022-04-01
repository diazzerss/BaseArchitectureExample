package ru.diazzerss.recycler_view_example.di.modules

import dagger.Module
import dagger.Provides
import ru.diazzerss.recycler_view_example.data.network.Remote
import ru.diazzerss.recycler_view_example.data.network.RemoteImpl
import javax.inject.Singleton

@Module
class RemoteModule {

    @Provides
    @Singleton
    fun provideRemote(): Remote = RemoteImpl()
}