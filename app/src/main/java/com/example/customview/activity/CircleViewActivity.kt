package com.example.customview.activity

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customview.R
import com.example.customview.dp
import com.example.customview.view.CircleView

class CircleViewActivity : AppCompatActivity() {
    lateinit var circleView: CircleView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circle_view)
        circleView = findViewById(R.id.circle_view)
        val animator = ObjectAnimator.ofFloat(circleView, "radius", 150.dp)
        animator.startDelay = 1000
        animator.start()
    }
}