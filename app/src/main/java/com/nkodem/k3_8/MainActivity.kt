package com.nkodem.k3_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
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


fun quicksort(items:List<Int>):List<Int>{
    if (items.count() < 2){
        return items
    }
    val pivot = items[items.count()/2]

    val equal = items.filter { it == pivot }

    val less = items.filter { it < pivot }

    val greater = items.filter { it > pivot }

    return quicksort(less) + equal + quicksort(greater)
}

fun mergeSort(list: List<Int>): List<Int> {
    if (list.size <= 1) {
        return list
    }

    val middle = list.size / 2
    var left = list.subList(0,middle);
    var right = list.subList(middle,list.size);

    return merge(mergeSort(left), mergeSort(right))
}
fun merge(left: List<Int>, right: List<Int>): List<Int>  {
    var indexLeft = 0
    var indexRight = 0
    var newList : MutableList<Int> = mutableListOf()

    while (indexLeft < left.count() && indexRight < right.count()) {
        if (left[indexLeft] <= right[indexRight]) {
            newList.add(left[indexLeft])
            indexLeft++
        } else {
            newList.add(right[indexRight])
            indexRight++
        }
    }

    while (indexLeft < left.size) {
        newList.add(left[indexLeft])
        indexLeft++
    }

    while (indexRight < right.size) {
        newList.add(right[indexRight])
        indexRight++
    }
    return newList;
}

fun insertionsort(items:IntArray):IntArray{
    if (items.isEmpty() || items.size<2){
        return items
    }
    for (count in 1..items.count() - 1){
        // println(items)
        val item = items[count]
        var i = count
        while (i>0 && item < items[i - 1]){
            items[i] = items[i - 1]
            i -= 1
        }
        items[i] = item
    }
    return items
}

fun selection_sort(sampleArray:IntArray){
    var n=sampleArray.size
    var temp:Int
    for(i in 0..n-1){
        var indexOfMin = i
        for(j in n-1 downTo  i){
            if(sampleArray[j]< sampleArray[indexOfMin])
                indexOfMin=j
        }
        if(i!=indexOfMin){
            temp = sampleArray[i]
            sampleArray[i]= sampleArray[indexOfMin]
            sampleArray[indexOfMin]=temp
        }
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ileElementow = 1000 //zmienic na pobieranie z edittext
        val ileRazy = 1000 //zmienic na pobieranie z edittext
        val tablica = IntArray(ileElementow){Random.nextInt(1,10)}
        findViewById<Button>(R.id.button1).setOnClickListener {
            val czas1 = System.currentTimeMillis()
            for (i in 0 until ileRazy)
            {
                bubbleSort(tablica)
            }
            val czas2 = System.currentTimeMillis()
            val czas3 = (czas2-czas1).toString()
            findViewById<TextView>(R.id.textView4).text = findViewById<TextView>(R.id.textView4).text.toString() + czas3

            val czas4 = System.currentTimeMillis()
            for (i in 0 until ileRazy)
            {
                quicksort(tablica.asList())
            }
            val czas5 = System.currentTimeMillis()
            val czas6 = (czas5-czas4).toString()
            findViewById<TextView>(R.id.textView6).text = findViewById<TextView>(R.id.textView6).text.toString() + czas6

            val czas7 = System.currentTimeMillis()
            for (i in 0 until ileRazy)
            {
                mergeSort(tablica.asList())
            }
            val czas8 = System.currentTimeMillis()
            val czas9 = (czas8-czas7).toString()
            findViewById<TextView>(R.id.textView5).text = findViewById<TextView>(R.id.textView5).text.toString() + czas9

            val czas10 = System.currentTimeMillis()
            for (i in 0 until ileRazy)
            {
                insertionsort(tablica)
            }
            val czas11 = System.currentTimeMillis()
            val czas12 = (czas11-czas10).toString()
            findViewById<TextView>(R.id.textView7).text = findViewById<TextView>(R.id.textView7).text.toString() + czas12

            val czas13 = System.currentTimeMillis()
            for (i in 0 until ileRazy)
            {
                selection_sort(tablica)
            }
            val czas14 = System.currentTimeMillis()
            val czas15 = (czas14-czas13).toString()
            findViewById<TextView>(R.id.textView8).text = findViewById<TextView>(R.id.textView8).text.toString() + czas15

        }

    }
}