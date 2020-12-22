package com.yehia.mira_keyboard_utils.view.base

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yehia.mira_keyboard_utils.data.network.login_models.DataSource
import com.yehia.mira_keyboard_utils.data.network.login_models.GeneralRequest
import kotlinx.coroutines.*

open class BaseViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    val generalRequest = MutableLiveData<GeneralRequest>()
    val dataSource = MutableLiveData<DataSource>()

    protected var viewModelJob = Job()
    protected val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    fun generalRequest(deferred: Deferred<GeneralRequest>) {
        coroutineScope.launch {

            try {
                val listResult = deferred.await()
                _response.value = "Success: yu are Loged in"
                generalRequest.value = listResult
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
                Log.d("login error response", "${e.message}")

            }
        }
    }

    fun dataSource(deferred: Deferred<DataSource>) {
        coroutineScope.launch {

            try {
                val listResult = deferred.await()
                _response.value = "Success: yu are Loged in"
                dataSource.value = listResult
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
                Log.d("login error response", "${e.message}")

            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
