package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.component

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class RoundedCornerImageView @JvmOverloads constructor(
    context : Context, attrs : AttributeSet, defStyleAttrs : Int =0
)  : AppCompatImageView(context, attrs, defStyleAttrs){
    private var cornerRadius = 32f

    private val path = Path()

    override fun onDraw(canvas: Canvas?) {
        val rectangle = RectF(0f, 0f, width.toFloat(), height.toFloat())

        path.addRoundRect(rectangle, cornerRadius, cornerRadius, Path.Direction.CCW)

        canvas?.clipPath(path)

        super.onDraw(canvas)
    }
}