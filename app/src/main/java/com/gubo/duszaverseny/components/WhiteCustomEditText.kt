package com.gubo.duszaverseny.components

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.gubo.duszaverseny.R

class WhiteCustomEditText(context: Context, attrs: AttributeSet) :
    AppCompatEditText(context, attrs) {

    init {
        setPadding(32, 32, 32, 32)
        background = ContextCompat.getDrawable(context, R.drawable.rounded_white_button)
        inputType = android.text.InputType.TYPE_CLASS_TEXT
        textAlignment = TEXT_ALIGNMENT_CENTER
        gravity = android.view.Gravity.CENTER
        textSize = 22f
        setTextColor(context.getColor(R.color.primaryVariant))
    }
}
