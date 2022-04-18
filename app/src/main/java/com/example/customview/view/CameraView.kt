package com.example.customview.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.withSave
import com.example.customview.R
import com.example.customview.dp

class CameraView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap: Bitmap = getAvatar(200.dp.toInt())
    private val camera = Camera()
    private val bitmapSize = 200.dp
    private val bitmapPadding = 100.dp

    var topFlip = 0f
        set(value) {
            field = value
            invalidate()
        }

    var bottomFlip = 0f
        set(value) {
            field = value
            invalidate()
        }

    var flipRotation = 0f
        set(value) {
            field = value
            invalidate()
        }

    init {
        camera.setLocation(0f, 0f, -6 * resources.displayMetrics.density)
    }

    override fun onDraw(canvas: Canvas) {

        //上半部分
        canvas.withSave {
            canvas.translate(bitmapPadding + bitmapSize / 2, bitmapPadding + bitmapSize / 2)
            canvas.rotate(-flipRotation)
            camera.save()
            camera.rotateX(topFlip)
            camera.applyToCanvas(canvas)
            camera.restore()
            canvas.clipRect(
                -bitmapSize,
                -bitmapSize,
                bitmapSize,
                0f
            )
            canvas.rotate(flipRotation)
            canvas.translate(-(bitmapPadding + bitmapSize / 2), -(bitmapPadding + bitmapSize / 2))
            canvas.drawBitmap(bitmap, bitmapPadding, bitmapPadding, paint)
        }

        //下半部分
        canvas.withSave {
            canvas.translate(bitmapPadding + bitmapSize / 2, bitmapPadding + bitmapSize / 2)
            canvas.rotate(-flipRotation)
            camera.save()
            camera.rotateX(bottomFlip)
            camera.applyToCanvas(canvas)
            camera.restore()
            canvas.clipRect(
                -bitmapSize,
                0f,
                bitmapSize,
                bitmapSize
            )
            canvas.rotate(flipRotation)
            canvas.translate(-(bitmapPadding + bitmapSize / 2), -(bitmapPadding + bitmapSize / 2))
            canvas.drawBitmap(bitmap, bitmapPadding, bitmapPadding, paint)
        }
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