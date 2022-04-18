package com.example.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PathMeasure
import android.util.AttributeSet
import android.view.View


class TestView(context: Context?, atts: AttributeSet?) : View(context, atts) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val path = Path()//
    lateinit var pathMeasure: PathMeasure //测量path的长度
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
//        canvas.drawLine(50f, 50f, 100f, 100f, paint)
//        canvas.drawCircle(width / 2f, height / 2f, RADIUS, paint)
        canvas.drawPath(path, paint)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        path.reset()
        path.addCircle(width / 2f, height / 2f, RADIUS, Path.Direction.CCW)
        //最后一个表示绘制方向
        path.addRect(
            width / 2f - RADIUS,
            height / 2f,
            width / 2f + RADIUS,
            height / 2f + 2*RADIUS,
            Path.Direction.CW
        )
        pathMeasure = PathMeasure(path,false)
        path.fillType = Path.FillType.EVEN_ODD  //不管方向，镂空就用这个

        //最后一个参数，用于绘制多个图像时候，有相交的部分是留空还是填充
    }
}