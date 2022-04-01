package ru.diazzerss.recycler_view_example_api.domain.interactor

import kotlinx.coroutines.flow.Flow
import ru.diazzerss.core.FlowUseCase
import ru.diazzerss.core.None
import ru.diazzerss.recycler_view_example_api.domain.repository.Repository
import ru.diazzerss.recycler_view_example_api.domain.model.Item

class LoadData(private val repository: Repository) : FlowUseCase<List<Item>, None>() {
    override fun run(params: None): Flow<List<Item>> = repository.loadData()
}