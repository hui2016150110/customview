package com.example.customview.activity

import android.animation.ObjectAnimator
import android.animation.PointFEvaluator
import android.animation.TypeEvaluator
import android.graphics.PointF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customview.R
import com.example.customview.dp
import com.example.customview.view.PointView

class PointViewActivity : AppCompatActivity() {
    lateinit var pointView: PointView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_point_view)
        pointView = findViewById(R.id.point_view)

        val animator = ObjectAnimator.ofObject(pointView, "point", PointFEvaluator(),PointF(100.dp,200.dp))
        animator.startDelay = 1000
        animator.start()
    }

    class PointFEvaluator : TypeEvaluator<PointF> {
        override fun evaluate(fraction: Float, startValue: PointF, endValue: PointF): PointF {
            val startX = startValue.x
            val endX = endValue.x
            val curX = startX + (endX - startX) * fraction
            val startY = startValue.x
            val endY = endValue.x
            val curY = startY + (endY - startY) * fraction
            return PointF(curX,curY)
        }

    }
}