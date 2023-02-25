package com.geektech.mvp12.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.geektech.mvp12.R
import com.geektech.mvp12.databinding.ActivityMainBinding
import com.geektech.mvp12.presenter.CounterPresenter

class MainActivity : AppCompatActivity(), MainActivityView {

    private lateinit var binding: ActivityMainBinding
    private val presenter=CounterPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        onClick()
    }

    override fun updateCounterView(model: Int) {
        if(model==10)
            sendToastMessage("Congratulations")
        if(model==15)
            binding.tvCounter.setTextColor(resources.getColor(R.color.red))
        else binding.tvCounter.setTextColor(resources.getColor(R.color.black))
        binding.tvCounter.text=model.toString()
    }

    override fun sendToastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun onClick(){

        binding.btnIncrement.setOnClickListener{

            presenter.increment()
        }

        binding.btnDecrement.setOnClickListener {

            presenter.decrement()
        }

    }
}