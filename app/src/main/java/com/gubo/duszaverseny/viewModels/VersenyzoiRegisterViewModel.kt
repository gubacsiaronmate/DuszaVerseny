package com.gubo.duszaverseny.viewModels

import android.content.Context
import android.util.TypedValue
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gubo.duszaverseny.R
import com.gubo.duszaverseny.components.BlueCustomButton
import com.gubo.duszaverseny.components.TransparentCustomEditText
import com.gubo.duszaverseny.data.Student
import com.gubo.duszaverseny.repositories.getStudents
import com.gubo.duszaverseny.util.convertTo

class VersenyzoiRegisterViewModel : ViewModel() {
    private val _versenyzok = MutableLiveData<MutableList<Student>>()
    val versenyzok: MutableLiveData<MutableList<Student>> = _versenyzok

    private val nameEditTextId = View.generateViewId()
    private val gradeEditTextId = View.generateViewId()

    fun getAddedTeamMateLinearLayout(context: Context, student: Student): LinearLayout = LinearLayout(context).apply {
        background = ContextCompat.getDrawable(context, R.drawable.rounded_white_button)
        orientation = LinearLayout.HORIZONTAL
        val sizeInDp = 24
        val sizeInPx = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            sizeInDp.toFloat(),
            context.resources.displayMetrics
            ).toInt()
        setPadding(12, 12, 12, 12)
        addView(ImageView(context).apply {
            layoutParams = LinearLayout.LayoutParams(sizeInPx, sizeInPx)
            setImageResource(R.drawable.user)
        })
        addView(TextView(context).apply {
            setTextColor(ContextCompat.getColor(context, R.color.hintText))
            text = student.sName
        })
    }

    private fun createLinearLayout(context: Context, imageRes: Int, hintRes: Int): LinearLayout =
        LinearLayout(context).apply {
            orientation = LinearLayout.HORIZONTAL
            val sizeInDp = 24
            val sizeInPx = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                sizeInDp.toFloat(),
                context.resources.displayMetrics
            ).toInt()
            setPadding(12, 12, 12, 12)
            addView(ImageView(context).apply {
                layoutParams = LinearLayout.LayoutParams(sizeInPx, sizeInPx)
                setImageResource(imageRes)
            })
            addView(TransparentCustomEditText(context).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                id = nameEditTextId
                hint = context.getString(hintRes)
            })
        }

    fun getTeamMateDataUIGenerator(context: Context): LinearLayout = LinearLayout(context).apply {
        orientation = LinearLayout.VERTICAL
        addView(createLinearLayout(context, R.drawable.user, R.string.versenyzoName))
        addView(createLinearLayout(context, R.drawable.school2, R.string.versenyzoGrade))
        addView(BlueCustomButton(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                marginStart = 16
                marginEnd = 16
                topMargin = 8
                bottomMargin = 8
            }
            setPadding(12, 12, 12, 12)
            text = context.getString(R.string.submit_btn)
            setOnClickListener {
                _versenyzok.value?.add(
                    Student(
                        getStudents().last().id + 1,
                        findViewById<EditText>(nameEditTextId).text.toString(),
                        findViewById<EditText>(gradeEditTextId).text convertTo Int::class
                    )
                )
            }
        })
    }
}