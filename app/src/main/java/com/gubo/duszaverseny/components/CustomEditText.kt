package com.gubo.duszaverseny.components

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout.LayoutParams
import androidx.appcompat.content.res.AppCompatResources
import com.gubo.duszaverseny.R

class CustomEditText(context: Context, attrs: AttributeSet):
    androidx.appcompat.widget.AppCompatEditText(context, attrs) {
    init {
        val params = LayoutParams(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT
        ).apply {
            setMargins(0, 40, 0, 0)
        }
        layoutParams = params
        setPadding(0, 16, 0, 16)
        background = AppCompatResources.getDrawable(context, R.drawable.rounded_blue_button)
        inputType = android.text.InputType.TYPE_CLASS_TEXT
        textAlignment = TEXT_ALIGNMENT_CENTER
        gravity = android.view.Gravity.CENTER
        textSize = 22f
        setTextColor(context.getColor(R.color.primaryVariant))
    }
}