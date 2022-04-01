package ru.diazzerss.example1.data

import ru.diazzerss.example1_api.domain.repository.Repository
import ru.diazzerss.core.Either
import ru.diazzerss.core.None
import ru.diazzerss.example1.data.cache.Cache

internal class RepositoryImpl(private val cache: Cache) : Repository {
    override fun getDataFromCache(): Either<None, String> = cache.getData()
}