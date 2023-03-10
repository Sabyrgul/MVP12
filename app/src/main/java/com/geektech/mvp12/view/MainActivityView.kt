package com.geektech.mvp12.view

import androidx.lifecycle.ViewModel
import com.geektech.mvp12.model.CounterModel

class MainActivityViewModel:ViewModel() {

    private val counterModel= CounterModel()

    fun increment(){
        counterModel.increment()
    }

    fun decrement(){
        counterModel.decrement()
    }

    fun checkCounter():Int {
    return counterModel.counter
    }

}