package ru.diazzerss.recycler_view_example.presentation.view_model

import android.app.Application
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.diazzerss.core.None
import ru.diazzerss.presentation.base.BaseViewModel
import ru.diazzerss.presentation.base.recycler_view.RecyclerViewBaseDataModel
import ru.diazzerss.presentation.extensions.launchOn
import ru.diazzerss.recycler_view_example_api.domain.interactor.LoadData
import ru.diazzerss.recycler_view_example_api.domain.model.Item
import javax.inject.Inject

class RecyclerViewExampleViewModel @Inject constructor(
    application: Application,
    private val loadData: LoadData
) : BaseViewModel(application) {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _items = MutableStateFlow<List<Item>>(emptyList())
    var items = _items.asStateFlow()

    override fun init() {
        _isLoading.value = true
        loadData(None()).launchOn(viewModelScope, ::onDataLoaded)
    }

    private fun onDataLoaded(data: List<Item>) {
        _items.value = data
        _isLoading.value = false
    }

    fun toRecyclerViewItems(items: List<Item>): List<RecyclerViewBaseDataModel> {
        val newList = mutableListOf<RecyclerViewBaseDataModel>()
        items.forEach { newList.add(RecyclerViewBaseDataModel(it.name, it.type)) }
        return newList
    }
}