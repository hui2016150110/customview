package com.example.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class CameraView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap: Bitmap = getAvatar(200.dp.toInt())
    private val camera = Camera()
    private val bitmapSize = 200.dp
    private val bitmapPadding = 100.dp

    init {
        camera.rotateX(30f)
        camera.setLocation(0f, 0f, -6 * resources.displayMetrics.density)
    }

    override fun onDraw(canvas: Canvas) {

        //上半部分
        canvas.save()
        canvas.translate(bitmapPadding + bitmapSize / 2, bitmapPadding + bitmapSize / 2)
        canvas.rotate(-30f)

        canvas.clipRect(
            -bitmapSize,
            -bitmapSize,
            bitmapSize,
            0f
        )
        canvas.rotate(30f)

        canvas.translate(-(bitmapPadding + bitmapSize / 2), -(bitmapPadding + bitmapSize / 2))
        canvas.drawBitmap(bitmap, bitmapPadding, bitmapPadding, paint)
        canvas.restore()

        //下半部分
        canvas.save()
        canvas.translate(bitmapPadding + bitmapSize / 2, bitmapPadding + bitmapSize / 2)
        canvas.rotate(-30f)

        camera.applyToCanvas(canvas)
        canvas.clipRect(
            -bitmapSize,
            0f,
            bitmapSize,
            bitmapSize
        )
        canvas.rotate(30f)
        canvas.translate(-(bitmapPadding + bitmapSize / 2), -(bitmapPadding + bitmapSize / 2))
        canvas.drawBitmap(bitmap, bitmapPadding, bitmapPadding, paint)
        canvas.restore()
    }

    private fun getAvatar(width: Int): Bitmap {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.mipmap.avatar, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.mipmap.avatar, options)
    }
}