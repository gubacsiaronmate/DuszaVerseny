package com.gubo.duszaverseny.components

import android.content.Context
import android.util.AttributeSet
import com.gubo.duszaverseny.R

class BasicCustomButton(context: Context, attrs: AttributeSet) :
    androidx.appcompat.widget.AppCompatButton(context, attrs) {
    init {
        setBackgroundColor(context.getColor(R.color.white))
        setTextColor(context.getColor(R.color.primaryVariant))
        textAlignment = TEXT_ALIGNMENT_CENTER
        textSize = 12f
    }
}
