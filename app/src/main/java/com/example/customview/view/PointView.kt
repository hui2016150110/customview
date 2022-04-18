package com.example.customview.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View
import com.example.customview.dp

class PointView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    var point = PointF(0f, 0f)
        set(value) {
            field = value
            invalidate()
        }
    val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeCap = Paint.Cap.ROUND
        strokeWidth = 20.dp
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawPoint(point.x, point.y, paint)
    }

}