package com.gubo.duszaverseny.components

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.content.res.AppCompatResources
import com.gubo.duszaverseny.R

class deleteButton(context: Context, attrs: AttributeSet) :
    AppCompatImageButton(context, attrs) {
    init {
        setImageDrawable(AppCompatResources.getDrawable(context, R.drawable.delete))
        background = AppCompatResources.getDrawable(context, R.drawable.red_circle)
        setPadding(32, 32, 32, 32)
        scaleType = ScaleType.CENTER
        contentDescription = context.getString(R.string.delete_button_description)
    }
}