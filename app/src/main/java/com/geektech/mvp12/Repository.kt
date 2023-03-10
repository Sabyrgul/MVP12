package com.geektech.mvp12

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.geektech.mvp12.model.CounterModel

class Repository {
    fun counter(): LiveData<CounterModel> {

        val liveData= MutableLiveData<CounterModel>()
        return liveData
    }
}