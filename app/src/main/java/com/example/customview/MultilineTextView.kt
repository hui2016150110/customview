package com.example.customview

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View

class MultilineTextView(context: Context, attributeSet: AttributeSet) :
    View(context, attributeSet) {
    val text =
        "Aliquam erat volutpat. Vestibulum risus tortor, tempus at arcu ut, imperdiet efficitur nulla. Fusce blandit hendrerit urna quis congue. Vestibulum suscipit dolor vitae vulputate bibendum. Cras consectetur sem a lorem lobortis fringilla. Nam cursus sollicitudin tellus non maximus. Duis a mi mattis dolor porta dignissim. Fusce vitae felis eu sem pulvinar hendrerit. Etiam semper erat condimentum, tempus magna sed, dignissim lacus. Etiam fringilla tortor at purus euismod, eget auctor massa ultricies. Nulla pharetra eget justo nec hendrerit. Vivamus ullamcorper massa ac nunc auctor, at ultrices erat pulvinar. Suspendisse aliquam lectus libero, vel cursus metus vulputate et. Aliquam lacus enim, bibendum quis erat et, tempus vulputate erat. Nam vitae euismod magna. Sed aliquet volutpat nisi."


    private val imageSize = 100.dp
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 16.dp
    }
    private var fontMetrics: Paint.FontMetrics = Paint.FontMetrics()
    private val imagePadding = 50.dp
    override fun onDraw(canvas: Canvas) {
        canvas.drawBitmap(getAvatar(imageSize.toInt()), width - imageSize, imagePadding, paint)
        paint.getFontMetrics(fontMetrics)
        val measuredWidth = floatArrayOf(0f)
        var start = 0
        var count: Int
        var verticalOffset = -fontMetrics.top
        var maxWidth: Float
        while (start < text.length) {
            if (verticalOffset+fontMetrics.bottom<imagePadding+imageSize && verticalOffset>imagePadding) {
                maxWidth = width - imageSize
            } else {
                maxWidth = width.toFloat()

            }
            count = paint.breakText(text, start, text.length, true, maxWidth, measuredWidth)
            canvas.drawText(
                text,
                start,
                start + count,
                0f,
                verticalOffset,
                paint
            )
            start += count
            verticalOffset += paint.fontSpacing

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