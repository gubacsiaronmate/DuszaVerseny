package com.gubo.duszaverseny.components

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout.LayoutParams
import androidx.appcompat.content.res.AppCompatResources
import com.gubo.duszaverseny.R

class CustomEditText(context: Context, attrs: AttributeSet):
    androidx.appcompat.widget.AppCompatEditText(context, attrs) {
    init {
        layoutParams = LayoutParams(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.MATCH_PARENT
        ).apply {
            setMargins(0, 0, 0, 16.dpToPx(context))
        }
        setPadding(0, 10.dpToPx(context), 0, 10.dpToPx(context))
        background = AppCompatResources.getDrawable(context, R.drawable.rounded_blue_button)
        inputType = android.text.InputType.TYPE_CLASS_TEXT
        textAlignment = TEXT_ALIGNMENT_CENTER
        gravity = android.view.Gravity.CENTER
        textSize = 22f
        setTextColor(context.getColor(R.color.primaryVariant))
    }

    private fun Int.dpToPx(context: Context): Int {
        return (this * context.resources.displayMetrics.density).toInt()
    }
}