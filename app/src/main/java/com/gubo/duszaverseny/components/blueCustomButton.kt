package com.gubo.duszaverseny.components

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout.LayoutParams
import androidx.appcompat.content.res.AppCompatResources
import com.gubo.duszaverseny.R

class blueCustomButton(context: Context, attrs: AttributeSet):
    androidx.appcompat.widget.AppCompatButton(context, attrs) {
    init {
        val params = LayoutParams(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT
        ).apply {
            setMargins(0, 20, 0, 0)
        }
        layoutParams = params

        setPadding(10, 20, 10, 20)
        background = AppCompatResources.getDrawable(context, R.drawable.rounded_blue_button)
        textAlignment = TEXT_ALIGNMENT_CENTER
        gravity = android.view.Gravity.CENTER
        textSize = 22f

        setTextColor(context.getColor(R.color.white))
    }
}