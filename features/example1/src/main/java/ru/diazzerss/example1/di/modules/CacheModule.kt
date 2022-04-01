package ru.diazzerss.example1.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

import ru.diazzerss.example1.data.cache.CacheImpl
import ru.diazzerss.example1.data.cache.SharedPrefsManager
import ru.diazzerss.example1.data.cache.Cache
import ru.diazzerss.presentation.base.BaseApplication

@Module
class CacheModule(private val context: Context) {
    @Provides
    fun provideAppContext(): Context = context

    @Provides
    fun provideApplication(): Application = context as BaseApplication

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideCache(prefsManager: SharedPrefsManager): Cache {
        return CacheImpl(prefsManager)
    }
}