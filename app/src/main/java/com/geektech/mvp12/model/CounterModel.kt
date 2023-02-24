package com.geektech.mvp12.model

import android.util.Log

class CounterModel {

    var counter=0

    fun increment(){
        counter++
        Log.e("New Tag","$counter")
    }

    fun decrement(){
        counter--
        Log.e("New Tag","$counter")
    }


}