package com.example.madlab_cb

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val pizza = findViewById<CheckBox>(R.id.cbPizza)
        val burger = findViewById<CheckBox>(R.id.cbBurger)
        val coffee = findViewById<CheckBox>(R.id.cbCoffee)
        val button = findViewById<Button>(R.id.btnCalculate)

        button.setOnClickListener {

            var total = 0

            if (pizza.isChecked) {
                total += 150
            }

            if (burger.isChecked) {
                total += 120
            }

            if (coffee.isChecked) {
                total += 80
            }

            Toast.makeText(this, "Total Bill = ₹$total", Toast.LENGTH_LONG).show()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}