package ru.diazzerss.example2.data.remote

import ru.diazzerss.example2_api.type.Failure
import ru.diazzerss.core.Either

interface Remote {
    fun getData(name: String, secondName: String): Either<Failure, String>
}