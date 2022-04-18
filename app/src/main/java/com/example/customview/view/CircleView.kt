package com.example.customview.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.toColorInt
import com.example.customview.dp

class CircleView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = "#007968".toColorInt()
    }
    var radius = 50.dp
        set(value) {
            field = value
            invalidate()
        }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(width / 2f, height / 2f, radius, paint)
    }
}