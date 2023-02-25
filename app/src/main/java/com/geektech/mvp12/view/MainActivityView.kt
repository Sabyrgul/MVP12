package com.geektech.mvp12.view

interface MainActivityView {

    fun updateCounterView(model:Int)

    fun sendToastMessage(message: String)
}