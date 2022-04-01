package ru.diazzerss.recycler_view_example.data

import kotlinx.coroutines.flow.Flow
import ru.diazzerss.recycler_view_example.data.network.Remote
import ru.diazzerss.recycler_view_example_api.domain.repository.Repository
import ru.diazzerss.recycler_view_example_api.domain.model.Item

class RepositoryImpl(private val remote: Remote) : Repository {
    override fun loadData(): Flow<List<Item>> = remote.loadDataFromServer()
}