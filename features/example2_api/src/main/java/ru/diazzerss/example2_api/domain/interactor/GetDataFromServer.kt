package ru.diazzerss.example2_api.domain.interactor

import ru.diazzerss.example2_api.domain.interactor.GetDataFromServer.Params
import ru.diazzerss.example2_api.domain.repository.Repository
import ru.diazzerss.example2_api.type.Failure
import ru.diazzerss.core.AsyncUseCase
import ru.diazzerss.core.Either

class GetDataFromServer(private val repository: Repository) : AsyncUseCase<String, Params, Failure>() {

    data class Params (
        val name: String,
        val secondName: String
    )

    override suspend fun run(params: Params): Either<Failure, String> = repository.getDataFromServer(params.name, params.secondName)
}