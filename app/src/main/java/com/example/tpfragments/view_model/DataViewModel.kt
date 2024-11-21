package com.example.tpfragments.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel: ViewModel() {
    private val _data = MutableLiveData<ModelData>()
    val data: LiveData<ModelData> = _data

    fun init() {
        _data.value = ModelData(0)
    }

    fun updateData(data: Int) {
        _data.value = ModelData(data)
    }

    fun getDataValue() : Int {
        return _data.value?.compteur!!
    }
}