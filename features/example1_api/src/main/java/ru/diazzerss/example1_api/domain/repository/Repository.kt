package ru.diazzerss.example1_api.domain.repository

import ru.diazzerss.core.Either
import ru.diazzerss.core.None

interface Repository {
    fun getDataFromCache(): Either<None, String>
}