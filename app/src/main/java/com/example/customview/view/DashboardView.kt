package com.example.customview.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.customview.R
import com.example.customview.px
import kotlin.math.cos
import kotlin.math.sin

val RADIUS = 150f.px
const val OPEN_ANGLE = 120f
val DASH_WIDTH = 2f.px
val DASH_LENGTH = 10f.px
val LENGTH = 120f.px
val ARROW_LENGTH = 20f.px
val ARROW_ANGLE = 60f

@SuppressLint("Recycle")
class DashboardView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val dash = Path()
    private val path = Path()
    private lateinit var pathEffect: PathEffect

    init {
        val array: TypedArray =
            context.obtainStyledAttributes(attributeSet, R.styleable.DashboardView)
        paint.strokeWidth = 3f.px
        paint.style = Paint.Style.STROKE
        dash.addRect(0f, 0f, DASH_WIDTH, DASH_LENGTH, Path.Direction.CCW)

    }

    override fun onDraw(canvas: Canvas) {
        //画弧
        canvas.drawPath(path, paint)

        //画刻度
        paint.pathEffect = pathEffect
        canvas.drawPath(path, paint)
        paint.pathEffect = null

        val pointStopX = width / 2f + LENGTH * cos(markToRadians(10)).toFloat()
        val pointStopY = height / 2f + LENGTH * sin(markToRadians(10)).toFloat()
        canvas.drawLine(
            width / 2f,
            height / 2f,
            pointStopX,
            pointStopY,
            paint
        )
        canvas.drawLine(
            pointStopX,
            pointStopY,
            pointStopX - ARROW_LENGTH * sin(Math.toRadians((ARROW_ANGLE / 2f).toDouble())).toFloat(),
            pointStopY + ARROW_LENGTH * cos(Math.toRadians((ARROW_ANGLE / 2f).toDouble())).toFloat(),
            paint
        )
        canvas.drawLine(
            pointStopX,
            pointStopY,
            pointStopX + ARROW_LENGTH * sin(Math.toRadians((ARROW_ANGLE / 2f).toDouble())).toFloat(),
            pointStopY + ARROW_LENGTH * cos(Math.toRadians((ARROW_ANGLE / 2f).toDouble())).toFloat(),
            paint
        )
    }

    private fun markToRadians(mark: Int) =
        Math.toRadians((90 + OPEN_ANGLE / 2f + (360 - OPEN_ANGLE) / 20f * mark).toDouble())

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        path.reset()
        path.addArc(
            width / 2f - RADIUS,
            height / 2f - RADIUS,
            width / 2f + RADIUS,
            height / 2f + RADIUS, 90 + OPEN_ANGLE / 2f, 360 - OPEN_ANGLE
        )
        val pathMeasure = PathMeasure(path, false)

        pathEffect = PathDashPathEffect(
            dash,
            (pathMeasure.length - DASH_WIDTH) / 20f,
            0f,
            PathDashPathEffect.Style.ROTATE
        )
    }
}