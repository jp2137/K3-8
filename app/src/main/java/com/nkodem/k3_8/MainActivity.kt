package com.nkodem.k3_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

fun bubbleSort(arr:IntArray):IntArray{
    var swap = true
    while(swap){
        swap = false
        for(i in 0 until arr.size-1){
            if(arr[i] > arr[i+1]){
                val temp = arr[i]
                arr[i] = arr[i+1]
                arr[i + 1] = temp

                swap = true
            }
        }
    }
    return arr
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ileElementow = findViewById<EditText>(R.id.editTextNumber).text.toString().toInt()
        val ileRazy = findViewById<EditText>(R.id.editTextNumber2).text.toString().toInt()
        val tablica = IntArray(ileElementow){Random.nextInt(1,10)}

        findViewById<Button>(R.id.button1).setOnClickListener {
            val czas1 = System.currentTimeMillis()
            for (i in 0 until ileRazy)
            {
                bubbleSort(tablica)
            }
            val czas2 = System.currentTimeMillis()
            val czas3 = (czas2-czas1).toString()
            findViewById<TextView>(R.id.textView4).text = findViewById<TextView>(R.id.textView4).text.toString() + czas3*/
        }

    }
}