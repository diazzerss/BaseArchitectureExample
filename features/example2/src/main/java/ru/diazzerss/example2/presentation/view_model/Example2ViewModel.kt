package ru.diazzerss.example2.presentation.view_model

import android.app.Application
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.diazzerss.example2.R
import ru.diazzerss.example2_api.domain.interactor.GetDataFromServer
import ru.diazzerss.example2_api.type.Failure
import ru.diazzerss.presentation.base.BaseViewModel
import javax.inject.Inject

class Example2ViewModel @Inject constructor(
    application: Application,
    private val getDataFromServer: GetDataFromServer
) : BaseViewModel(application) {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _text = MutableStateFlow(context.getString(R.string.data_text))
    val text = _text.asStateFlow()

    override fun init() {
        loadData()
    }

    private fun loadData() {
        _isLoading.value = true

        getDataFromServer(GetDataFromServer.Params("Thomas", "Anderson")) {
            it.either(::onLoadDataFailed, ::onLoadDataSuccess)
            _isLoading.value = false
        }
    }

    private fun onLoadDataSuccess(data: String) {
        _text.value = data
    }

    private fun onLoadDataFailed(failure: Failure) {
        when (failure) {
            Failure.NetworkConnectionError -> TODO()
            Failure.ServerError -> TODO()
            Failure.ServerNotFoundError -> TODO()
            Failure.AuthorizationError -> TODO()
            Failure.AccountNotFoundError -> TODO()
            Failure.UnknownError -> TODO()
        }
    }
}