package ru.diazzerss.example1_api.domain.interactor

import ru.diazzerss.example1_api.domain.repository.Repository
import ru.diazzerss.core.Either
import ru.diazzerss.core.None
import ru.diazzerss.core.UseCase

class GetDataFromCache(private val repository: Repository) : UseCase<String, None, None>() {
    override fun run(params: None): Either<None, String> = repository.getDataFromCache()
}