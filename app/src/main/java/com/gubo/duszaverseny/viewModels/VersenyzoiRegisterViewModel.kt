package com.gubo.duszaverseny.viewModels

import android.content.Context
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.children
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gubo.duszaverseny.R
import com.gubo.duszaverseny.components.BlueCustomButton
import com.gubo.duszaverseny.components.TransparentCustomEditText
import com.gubo.duszaverseny.data.Student
import com.gubo.duszaverseny.repositories.getStudents
import com.gubo.duszaverseny.util.convertTo
import kotlinx.coroutines.launch

class VersenyzoiRegisterViewModel : ViewModel() {
    private val _versenyzok = MutableLiveData<MutableList<Student>>()
    val versenyzok: MutableLiveData<MutableList<Student>> = _versenyzok

    fun updateVersenyzok(versenyzok: MutableList<Student>) {
        _versenyzok.value = versenyzok
    }

    private val nameEditTextId = View.generateViewId()
    private val gradeEditTextId = View.generateViewId()
    private val secondLinLayoutId = View.generateViewId()

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
        addView(TextView(context).apply {
            setTextColor(ContextCompat.getColor(context, R.color.hintText))
            text = student.grade convertTo String::class
        })
    }

    private fun createLinearLayout(context: Context, imageRes: Int, hintRes: Int, givenId: Int, secondLinLayoutId: Int? = null): LinearLayout =
        LinearLayout(context).apply {
            id = secondLinLayoutId ?: View.generateViewId()
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
                id = givenId
                hint = context.getString(hintRes)
            })
        }

    fun getTeamMateDataUIGenerator(context: Context): LinearLayout = LinearLayout(context).apply {
        R.id.versenyzoiRegisterLinearLayout = View.generateViewId()
        id = R.id.versenyzoiRegisterLinearLayout
        orientation = LinearLayout.VERTICAL

        Log.d("Test", "nameEditTextId: $nameEditTextId")
        Log.d("Test", "gradeEditTextId: $gradeEditTextId")

        addView(createLinearLayout(context, R.drawable.user, R.string.versenyzoName, nameEditTextId))
        addView(createLinearLayout(context, R.drawable.school2, R.string.versenyzoGrade, gradeEditTextId, secondLinLayoutId))
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
                val linLayout = this.parent as LinearLayout
                val sName = linLayout.children.first().findViewById<EditText>(nameEditTextId).text.toString()
                val grade = linLayout.children.find { it -> it.id == secondLinLayoutId }
                    ?.findViewById<EditText>(gradeEditTextId)?.text.toString() convertTo Int::class

                Log.d("Test", "sName: $sName")
                Log.d("Test", "grade: $grade")

                var student: Student = Student(0, "", 0)

                viewModelScope.launch {
                    student = Student(getStudents().last().id + 1, sName, grade)
                }
                _versenyzok.value?.add(student)
                getAddedTeamMateLinearLayout(context, student)
            }
        })
    }
}