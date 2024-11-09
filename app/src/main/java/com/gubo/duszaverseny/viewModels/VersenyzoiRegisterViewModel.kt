package com.gubo.duszaverseny.viewModels

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gubo.duszaverseny.R
import com.gubo.duszaverseny.data.Student
import com.gubo.duszaverseny.repositories.getStudents
import com.gubo.duszaverseny.util.convertTo

class VersenyzoiRegisterViewModel : ViewModel() {
    private val _versenyzok = MutableLiveData<MutableList<Student>>()
    val versenyzok: MutableLiveData<MutableList<Student>> = _versenyzok

    private fun createLinearLayout(context: Context, imageRes: Int, hintRes: Int): LinearLayout {
        val nameEditTextId = View.generateViewId()
        val gradeEditTextId = View.generateViewId()

        return LinearLayout(context).apply {
            orientation = LinearLayout.HORIZONTAL
            setPadding(12, 12, 12, 12)
            addView(ImageView(context).apply {
                setImageResource(imageRes)
            })
            addView(EditText(context).apply {
                id = nameEditTextId
                hint = context.getString(hintRes)
            })
            addView(EditText(context).apply {
                id = gradeEditTextId
                hint = context.getString(R.string.versenyzoGrade)
            })
            addView(Button(context).apply {
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

    fun getTeamMateDataUIGenerator(context: Context): LinearLayout {
        return LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            addView(createLinearLayout(context, R.drawable.user, R.string.versenyzoName))
            addView(createLinearLayout(context, R.drawable.school2, R.string.versenyzoGrade))
        }
    }
}