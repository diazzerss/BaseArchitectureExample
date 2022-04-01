package ru.diazzerss.recycler_view_example_api.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.diazzerss.recycler_view_example_api.domain.model.Item

interface Repository {
    fun loadData(): Flow<List<Item>>
}