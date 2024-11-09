package com.gubo.duszaverseny.components

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.content.res.AppCompatResources
import com.gubo.duszaverseny.R

class whiteCustomEditText(context: Context, attrs: AttributeSet):
    androidx.appcompat.widget.AppCompatEditText(context, attrs) {
    init {
        setPadding(16, 16, 16, 16)
        background = AppCompatResources.getDrawable(context, R.drawable.rounded_white_button)
        inputType = android.text.InputType.TYPE_CLASS_TEXT
        textAlignment = TEXT_ALIGNMENT_TEXT_START
        gravity = android.view.Gravity.START
        textSize = 22f
        setTextColor(context.getColor(R.color.primaryVariant))
    }
}