package com.example.fabonaccisequence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.math.BigInteger

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rvNumbers = findViewById<RecyclerView>(R.id.rvNumbers)
        rvNumbers.layoutManager = LinearLayoutManager(baseContext)

        var numbersAdapter = NumberSequences(hunter(100))
        rvNumbers.adapter = numbersAdapter
    }
    fun hunter(n:Int):List<BigInteger>{
        var numList = MutableList<BigInteger>(n,{BigInteger.ZERO})
        var n1 = BigInteger.ZERO
        var n2 = BigInteger.ONE
        numList[0]=n1
        numList[1]=n2
        for(i in 1..n){
            val sum = n1 + n2
            n1 = n2
            n2 = sum
            numList[i-1]= n1

        }
        return numList
    }
}