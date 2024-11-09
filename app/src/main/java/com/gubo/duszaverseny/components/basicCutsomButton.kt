package com.gubo.duszaverseny.components

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.content.res.AppCompatResources
import com.gubo.duszaverseny.R

class BasicCustomButton(context: Context, attrs: AttributeSet) : AppCompatButton(context, attrs) {
    init {
        setBackgroundColor(context.getColor(R.color.white))
        setTextColor(context.getColor(R.color.primaryVariant))
        textAlignment = TEXT_ALIGNMENT_CENTER
        typeface = android.graphics.Typeface.DEFAULT
    }
}