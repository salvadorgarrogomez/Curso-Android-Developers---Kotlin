package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
            // val resultTextView: TextView = findViewById(R.id.textView)
            // resultTextView.text = "Dice Rolled!"
            rollDice()
        }
    }
    /*
        Funcion private, que llamando a la funcion Dice() se establece el numero final del random, en este caso
        el random se ejecutara entre 1 y 6, siendo este margen las caras de un dado.
        Acto seguido, cada vez que con el Button se le da al ClickListener, con esta funcion saldra el numero en el TextView
    */
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}

// Funcion para establecer el random() donde el numero unicial es el 1
class Dice(private val numSides: Int){
    fun roll(): Int{
        return (1..numSides).random()
    }
}