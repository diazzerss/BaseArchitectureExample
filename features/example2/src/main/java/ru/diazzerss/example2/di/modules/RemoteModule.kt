package ru.diazzerss.example2.di.modules

import dagger.Module
import dagger.Provides
import ru.diazzerss.example2.data.remote.Remote
import ru.diazzerss.example2.data.remote.RemoteImpl

@Module
class RemoteModule {
    @Provides
    fun provideRemote(): Remote {
        return RemoteImpl()
    }
}