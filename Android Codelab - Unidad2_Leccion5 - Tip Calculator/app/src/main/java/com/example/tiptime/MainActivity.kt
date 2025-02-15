package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    // Palabra clave, es una promesa de que el codigo inicializara la variable antes de usarla
    // Hay que agregar el buildFeatures en el gradle.kts (Module)
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip(){
        val stringIntTextField = binding.costOfService.text.toString()
        val cost = stringIntTextField.toDoubleOrNull()
        if (cost == null || cost == 0.0){
            displayTip(0.0)
            return
        }
        val tipPercentage = when(binding.tipOptions.checkedRadioButtonId){
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else-> 0.15
        }
        var tip = tipPercentage * cost
        if (binding.roundUpSwitch.isChecked){
            tip = kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(0.0)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
        displayTip(tip)
    }

    private fun displayTip(tip: Double){
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}