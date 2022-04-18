package com.example.customview.activity

import android.animation.Animator
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customview.R
import com.example.customview.view.ProvinceEvaluator
import com.example.customview.view.ProvinceView

class ProvinceActivity : AppCompatActivity() {
    lateinit var provinceView: ProvinceView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_province)
        provinceView = findViewById(R.id.province_view)
        val animator = ObjectAnimator.ofObject(provinceView,"province",ProvinceEvaluator(),"澳门特别行政区")
        animator.startDelay = 1000
        animator.duration = 10000
        animator.start()
    }
}