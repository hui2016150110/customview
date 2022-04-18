package com.example.customview.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.customview.dp

private val CIRCLE_COLOR = Color.parseColor("#90A4AE")
private val HIGHLIGHT_COLOR = Color.parseColor("#FF4081")
private val RING_WIDTH = 20.dp

class SportView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 100.dp
        textAlign = Paint.Align.CENTER
    }
    private val RADIUS = 150.dp
    private val bounds = Rect()
    private val fontMetrics = Paint.FontMetrics()
    override fun onDraw(canvas: Canvas) {
        paint.style = Paint.Style.STROKE
        paint.color = CIRCLE_COLOR
        paint.strokeWidth = RING_WIDTH
        canvas.drawCircle(width / 2f, height / 2f, RADIUS, paint)

        paint.color = HIGHLIGHT_COLOR
        paint.strokeCap = Paint.Cap.ROUND
        canvas.drawArc(
            width / 2f - RADIUS,
            height / 2f - RADIUS,
            width / 2f + RADIUS,
            height / 2f + RADIUS,
            -90f,
            225f,
            false,
            paint
        )

        paint.style = Paint.Style.FILL
        paint.getFontMetrics(fontMetrics)
        canvas.drawText(
            "小黄",
            width / 2f,
            height / 2f - (fontMetrics.top + fontMetrics.bottom) / 2,
            paint
        )

    }
}