package com.geektech.mvp12.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.geektech.mvp12.R
import com.geektech.mvp12.databinding.ActivityMainBinding
import com.geektech.mvp12.presenter.CounterPresenter

class MainActivity : AppCompatActivity(), MainActivityView {

    private lateinit var binding: ActivityMainBinding
    private val presenter = CounterPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        onClick()
    }

    override fun updateCounterView(model: Int) {

        binding.tvCounter.text = model.toString()
    }

    override fun sendToastMessage() {
        Toast.makeText(this, "Congratulations!!!", Toast.LENGTH_SHORT).show()
    }

    override fun changeColor() {
        if (binding.tvCounter.currentTextColor == resources.getColor(R.color.black))
            binding.tvCounter.setTextColor(resources.getColor(R.color.red))
        else
            binding.tvCounter.setTextColor(resources.getColor(R.color.black))
    }

    private fun onClick() {

        binding.btnIncrement.setOnClickListener {
            presenter.increment()
            presenter.checkCounter()
        }

        binding.btnDecrement.setOnClickListener {
            presenter.decrement()
            presenter.checkCounter()
        }

    }
}