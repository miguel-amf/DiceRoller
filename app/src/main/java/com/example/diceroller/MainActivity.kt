package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)


        rollButton.setOnClickListener { diceRoll() }

        diceRoll()
    }

    private fun diceRoll() {
        val diceImage1: ImageView = findViewById(R.id.Dice1)
        val diceImage2: ImageView = findViewById(R.id.Dice2)
        val dice = Dice(6)

        var diceRoll = dice.roll()
        var drawableRes = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage1.contentDescription = diceRoll.toString()
        diceImage1.setImageResource(drawableRes)

        diceRoll = dice.roll()
        drawableRes = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage2.contentDescription = diceRoll.toString()
        diceImage2.setImageResource(drawableRes)
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
