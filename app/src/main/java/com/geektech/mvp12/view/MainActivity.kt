package com.geektech.mvp12.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.geektech.mvp12.R
import com.geektech.mvp12.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClick()
    }

    fun checkNumber() {
        var counter = viewModel.checkCounter()
        binding.tvCounter.text = counter.toString()
        if (counter == 10) {
            Toast.makeText(this, "Congratulations!!!", Toast.LENGTH_SHORT).show()
        }
        if (counter == 15) {
            if (binding.tvCounter.currentTextColor == resources.getColor(R.color.black))
                binding.tvCounter.setTextColor(resources.getColor(R.color.red))
            else
                binding.tvCounter.setTextColor(resources.getColor(R.color.black))
        }
    }

    private fun onClick() {

        binding.btnIncrement.setOnClickListener {
            viewModel.increment()
            viewModel.checkCounter()
            checkNumber()
        }

        binding.btnDecrement.setOnClickListener {
            viewModel.decrement()
            viewModel.checkCounter()
            checkNumber()
        }

    }
}