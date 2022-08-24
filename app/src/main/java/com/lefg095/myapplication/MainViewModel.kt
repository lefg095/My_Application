package com.lefg095.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainViewModel: ViewModel() {

    private val _result = MutableLiveData<Boolean>()
    val result: LiveData<Boolean> get() = _result

    fun onSubmitClicked(arrayList: ArrayList<Data>){
        viewModelScope.launch {
            _result.value = withContext(Dispatchers.IO){
                validateData(arrayList)
            }

        }
    }

    private fun validateData(arrayList: ArrayList<Data>): Boolean{
        return arrayList.isEmpty()
    }

}