package com.gubo.duszaverseny.components

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.gubo.duszaverseny.R

class TransparentCustomEditText(context: Context, attrs: AttributeSet? = null) :
    AppCompatEditText(context, attrs) {
    init {
        setPadding(32, 32, 32, 32)
        background = null
        inputType = android.text.InputType.TYPE_CLASS_TEXT
        textAlignment = TEXT_ALIGNMENT_CENTER
        gravity = android.view.Gravity.CENTER
        textSize = 22f
        setTextColor(context.getColor(R.color.primaryVariant))
    }
}
