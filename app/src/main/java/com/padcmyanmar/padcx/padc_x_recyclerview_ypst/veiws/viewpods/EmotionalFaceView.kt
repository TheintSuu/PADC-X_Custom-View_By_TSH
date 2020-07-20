package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.viewpods

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class EmotionalFaceView (
    context : Context, attrs : AttributeSet
) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var faceColor = Color.YELLOW
    private var mouthColor = Color.BLACK
    private var eyeColor = Color.BLACK
    private var borderColor = Color.BLACK

    private val borderWidth = 4.0f
    private val size = 320

    private val mouthPath = Path()


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        drawfaceBackground(canvas)
        drawEyes(canvas)
        drawMouth(canvas)

    }

    private fun drawfaceBackground(canvas : Canvas){
        paint.color = faceColor
        paint.style = Paint.Style.FILL

        val radius = size/2f

        canvas.drawCircle(size/2f, size/2f, radius, paint)

        paint.color = borderColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth

        canvas.drawCircle(size/2f, size/2f, radius-borderWidth/2f, paint )
    }

    private fun drawEyes(canvas: Canvas){
        paint.color = eyeColor
        paint.style = Paint.Style.FILL

        val leftEyeRect = RectF(size * 0.32f, size*0.32f, size*0.43f, size*0.50f)

        canvas.drawOval(leftEyeRect, paint)

        val rightEyeRect = RectF(size * 0.57f, size*0.32f, size*0.68f, size*0.50f)

        canvas.drawOval(rightEyeRect, paint)
    }

    private fun drawMouth(canvas: Canvas){
        mouthPath.moveTo(size * 0.22f, size * 0.7f)

        mouthPath.quadTo(size * 0.5f, size * 0.8f, size * 0.78f , size * 0.7f)

        mouthPath.quadTo(size* 0.5f , size* 0.8f, size *0.22f, size * 0.7f )

        paint.color = mouthColor
        paint.style = Paint.Style.FILL

        canvas.drawPath(mouthPath, paint)
    }
}