package com.gubo.duszaverseny.components

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.content.res.AppCompatResources
import com.gubo.duszaverseny.R

class BackButton(context: Context, attrs: AttributeSet) :
    AppCompatImageButton(context, attrs) {

    init {
        setImageDrawable(AppCompatResources.getDrawable(context, R.drawable.backarrow2))
        background = AppCompatResources.getDrawable(context, R.drawable.white_circle)
        setPadding(16, 16, 16, 16)
        scaleType = ScaleType.CENTER
        contentDescription = context.getString(R.string.arrow_description)
    }
}
