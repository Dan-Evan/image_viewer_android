package com.example.imageviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nextButton: Button = findViewById(R.id.buttonNext)
        val previousButton: Button = findViewById(R.id.buttonPrevious)

        val index: Array<Int> = arrayOf(
            R.drawable.img001,
            R.drawable.img002,
            R.drawable.img003,
            R.drawable.img004,
            R.drawable.img005,
            R.drawable.img006,
            R.drawable.img007,
            R.drawable.img008,
            R.drawable.img009,
            R.drawable.img010
        )

        var counter = 0
        val length = index.size

        val displayImage: ImageView = findViewById(R.id.imageView)
        displayImage.setImageResource(index[counter])

        if (counter <= 0) {
            previousButton.isEnabled = false
        }

        Toast.makeText(this, "This is the first image.", Toast.LENGTH_LONG).show()

        nextButton.setOnClickListener {
            previousButton.isEnabled = true

            counter++
            if (counter >= (length - 1)) {
                nextButton.isEnabled = false
                Toast.makeText(this, "This is the last image.", Toast.LENGTH_LONG).show()

            }
            val displayImage: ImageView = findViewById(R.id.imageView)
            displayImage.setImageResource(index[counter])
        }

        previousButton.setOnClickListener {
            nextButton.isEnabled = true

            counter--
            if (counter <= 0) {
                previousButton.isEnabled = false
                Toast.makeText(this, "This is the first image.", Toast.LENGTH_LONG).show()
            }
            val displayImage: ImageView = findViewById(R.id.imageView)
            displayImage.setImageResource(index[counter])
        }

    }

}