package com.example.baumhoto.hellotoast

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var count: Int = 0
    private var showCount: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.showCount = findViewById(R.id.show_count)
    }

    fun showToast(view : View) {
        val toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT)
        toast.show()
    }

    fun countUp(view : View) {
        this.count++
        this.showCount?.text = count.toString()
    }
}
