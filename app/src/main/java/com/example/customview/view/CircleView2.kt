package com.example.customview.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.toColorInt
import com.example.customview.dp

class CircleView2(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = "#FF123456".toColorInt()
    }
    private val radius = 100.dp
    private val padding = 100.dp
    override fun onDraw(canvas: Canvas) {
        canvas.drawCircle(padding + radius, padding + radius, radius, paint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val size = ((padding + radius) * 2).toInt()

        val width = resolveSize(size,widthMeasureSpec)
        val height = resolveSize(size,heightMeasureSpec)
        setMeasuredDimension(width, height)
    }
}