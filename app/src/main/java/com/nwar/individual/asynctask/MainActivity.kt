package com.nwar.individual.asynctask

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val displayTime = findViewById<TextView>(R.id.displaytime)
        val start = findViewById<TextView>(R.id.start)
        val reset = findViewById<TextView>(R.id.reset)
        val async = AsyncTest(displayTime)
        start.setOnClickListener {
            async.execute()
        }
        reset.setOnClickListener {
            async.cancel(true)
            async.stop()
        }
    }
}