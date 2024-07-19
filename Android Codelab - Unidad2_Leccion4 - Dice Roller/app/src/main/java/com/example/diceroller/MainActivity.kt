package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        // Inicializador para mostrar el dado al abrir la app
        rollButton.setOnClickListener { rollDice() }
        rollDice()

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
        // Establecimiento del numero de caras del dado
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // val resultTextView: TextView = findViewById(R.id.textView)
        // resultTextView.text = diceRoll.toString()
        /*
        * Ambas formas de desarrollo para el bucle son correctas, la recomendada es la segunda
        val diceImage: ImageView = findViewById(R.id.imageView)
        when(diceRoll){
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }

         */
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when(diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }
}

// Funcion para establecer el random() donde el numero unicial es el 1
class Dice(private val numSides: Int){
    fun roll(): Int{
        return (1..numSides).random()
    }
}