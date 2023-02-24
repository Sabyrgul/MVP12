package com.geektech.mvp12.presenter

import android.widget.Toast
import com.geektech.mvp12.model.CounterModel
import com.geektech.mvp12.view.MainActivityView

class CounterPresenter {

    private lateinit var view:MainActivityView

    private val counterModel=CounterModel()

    fun increment(){
        counterModel.increment()
        view.updateCounterView(counterModel.counter)
    }

    fun decrement(){
        counterModel.decrement()
        view.updateCounterView(counterModel.counter)
    }

    fun attachView(view:MainActivityView){
     this.view=view
    }
}