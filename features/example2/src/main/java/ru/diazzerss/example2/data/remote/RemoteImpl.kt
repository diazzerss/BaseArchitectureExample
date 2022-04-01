package ru.diazzerss.example2.data.remote

import ru.diazzerss.example2_api.type.Failure
import ru.diazzerss.core.Either

internal class RemoteImpl : Remote {
    override fun getData(name: String, secondName: String): Either<Failure, String> {
        val data = "Hello world from server, $name $secondName!"

        for (i in 0 .. Int.MAX_VALUE) {
            //Имитация работы сервера
        }

        return Either.Right(data)
    }
}