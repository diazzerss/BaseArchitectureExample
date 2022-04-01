package ru.diazzerss.example2.data

import ru.diazzerss.example2.data.remote.Remote
import ru.diazzerss.example2_api.domain.repository.Repository
import ru.diazzerss.example2_api.type.Failure
import ru.diazzerss.core.Either

internal class RepositoryImpl(private val remote: Remote) : Repository {
    override fun getDataFromServer(name: String, secondName: String): Either<Failure, String>
            = remote.getData(name, secondName)
}