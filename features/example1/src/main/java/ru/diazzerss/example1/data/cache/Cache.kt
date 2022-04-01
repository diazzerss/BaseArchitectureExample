package ru.diazzerss.example1.data.cache

import ru.diazzerss.core.Either
import ru.diazzerss.core.None

interface Cache {
    fun getData(): Either<None, String>
}