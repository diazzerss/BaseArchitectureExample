package ru.diazzerss.example2_api.domain.repository

import ru.diazzerss.example2_api.type.Failure
import ru.diazzerss.core.Either

interface Repository {
    fun getDataFromServer(name: String, secondName: String): Either<Failure, String>
}