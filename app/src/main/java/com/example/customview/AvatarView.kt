package com.example.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class AvatarView(context:Context,attributeSet: AttributeSet):View(context,attributeSet) {
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bounds = RectF(0f.px,0f.px,500f.px,500f.px)
    private val XFERMODE = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    override fun onDraw(canvas: Canvas) {
        canvas.drawOval(40f.px,40f.px,260f.px,260f.px,paint)
        val count = canvas.saveLayer(bounds,null)
        canvas.drawOval(50f.px,50f.px,250f.px,250f.px,paint)
        paint.xfermode = XFERMODE
        canvas.drawBitmap(getAvatar(200f.px.toInt()),50f.px,50f.px,paint)
        canvas.restoreToCount(count)
        paint.xfermode = null
    }

    private fun getAvatar(width:Int):Bitmap{
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources,R.mipmap.avatar,options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources,R.mipmap.avatar,options)
    }
}