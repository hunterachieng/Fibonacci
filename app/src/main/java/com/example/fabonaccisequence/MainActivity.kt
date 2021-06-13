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

        var numbersAdapter = NumberSequences(fibonacci().take(100).toList())
        rvNumbers.adapter = numbersAdapter
    }

    fun fibonacci() = sequence<BigInteger>{
        var nums = Pair(0,1)
        while (true){
            yield(nums.first.toBigInteger())
            nums = Pair(nums.second,nums.first + nums.second)
        }
    }

}