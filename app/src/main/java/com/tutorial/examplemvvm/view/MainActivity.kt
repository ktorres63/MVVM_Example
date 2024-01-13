package com.tutorial.examplemvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.tutorial.examplemvvm.databinding.ActivityMainBinding
import com.tutorial.examplemvvm.viewmodel.CalculatorViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var calculatorViewModel: CalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        calculatorViewModel = ViewModelProvider(this).get(CalculatorViewModel::class.java)

        binding.btnCalculate.setOnClickListener{

            val num1 = binding.etNum1.text.toString().toIntOrNull() ?: 0
            val num2 = binding.etNum2.text.toString().toIntOrNull() ?: 0

            val result = calculatorViewModel.calculateSum(num1,num2)
            binding.tvResult.text = "${result.sum}"
        }

    }
}
























