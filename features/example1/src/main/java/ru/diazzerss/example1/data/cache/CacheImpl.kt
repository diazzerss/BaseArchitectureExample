package ru.diazzerss.example1.data.cache

import ru.diazzerss.core.Either
import ru.diazzerss.core.None

internal class CacheImpl(private val prefsManager: SharedPrefsManager) : Cache {
    override fun getData(): Either<None, String> = prefsManager.getData()
}