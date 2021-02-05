package com.maxwell.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var tvSelectedFood: TextView
    private lateinit var btDecide: Button
    private lateinit var etFood: EditText
    private lateinit var btAddFood: Button
    val foodList = arrayListOf("Chinese", "Burger", "Pizza")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvSelectedFood = findViewById(R.id.tvSelectedFood)
        etFood = findViewById(R.id.etFood)

        btDecide = findViewById(R.id.btDecide)
        btDecide.setOnClickListener { getRandomFood() }

        btAddFood = findViewById(R.id.btAddFood)
        btAddFood.setOnClickListener { addFood() }
    }

    private fun addFood() {
        if(etFood.text.isEmpty()){
            Toast.makeText(this, "You must to complete the food field", Toast.LENGTH_SHORT).show()
            return
        }

        val newFood = etFood.text.toString()
        foodList.add(newFood)

        Toast.makeText(this, "A new food was added!", Toast.LENGTH_SHORT).show()

        etFood.text.clear()
        println(foodList)
    }

    private fun getRandomFood() {
        val randomFood = Random.nextInt(foodList.count())
        tvSelectedFood.text = foodList[randomFood]
    }
}