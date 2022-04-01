package ru.diazzerss.example1.presentation.view_model

import android.app.Application
import kotlinx.coroutines.flow.*
import ru.diazzerss.example1.R
import ru.diazzerss.example1_api.domain.interactor.GetDataFromCache
import ru.diazzerss.core.None
import ru.diazzerss.presentation.base.BaseViewModel
import javax.inject.Inject

class Example1ViewModel @Inject constructor(
    application: Application,
    private val getDataFromCache: GetDataFromCache
    ) : BaseViewModel(application) {

    private val _result = MutableStateFlow("")
    val result: StateFlow<String> = _result.asStateFlow()

    override fun init() {
        getDataFromCache(None()) { it.either(::onLoadDataFromCacheFailed, ::onLoadDataFromCacheSuccess) }
    }

    private fun onLoadDataFromCacheSuccess(data: String) {
        _result.value = data
    }

    private fun onLoadDataFromCacheFailed(failed: None) {
        _result.value = context.getString(R.string.load_data_failed)
    }
}