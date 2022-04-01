package ru.diazzerss.recycler_view_example.data.network

import kotlinx.coroutines.flow.Flow
import ru.diazzerss.recycler_view_example_api.domain.model.Item

interface Remote {
    fun loadDataFromServer(): Flow<List<Item>>
}