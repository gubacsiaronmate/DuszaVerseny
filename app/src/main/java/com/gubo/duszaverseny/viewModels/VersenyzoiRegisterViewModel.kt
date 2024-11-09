package com.gubo.duszaverseny.viewModels

import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.lifecycle.ViewModel
import com.gubo.duszaverseny.R
import com.gubo.duszaverseny.VersenyzoiRegisterActivity

class VersenyzoiRegisterViewModel : ViewModel() {
    private val context = VersenyzoiRegisterActivity()
    
    private fun getTeamMateDataUIGenerator1(): LinearLayout {
        return LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL

            addView(LinearLayout(context).apply {
                orientation = LinearLayout.HORIZONTAL
                setPadding(12, 12, 12, 12)
                addView(ImageView(context).apply {
                    setImageResource(R.drawable.user)
                })
                addView(EditText(context).apply {
                    R.id.versenyzoName1 = View.generateViewId()
                    id = R.id.versenyzoName1
                    hint = R.string.versenyzoName.toString()
                })
            })

            addView(LinearLayout(context).apply {
                orientation = LinearLayout.HORIZONTAL
                setPadding(12, 12, 12, 12)
                addView(ImageView(context).apply {
                    setImageResource(R.drawable.school2)
                })
                addView(EditText(context).apply {
                    R.id.versenyzoName1 = View.generateViewId()
                    id = R.id.versenyzoName1
                    hint = R.string.versenyzoGrade.toString()
                })
            })
        }
    }

    private fun getTeamMateDataUIGenerator2(): LinearLayout {
        return LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL

            addView(LinearLayout(context).apply {
                orientation = LinearLayout.HORIZONTAL
                setPadding(12, 12, 12, 12)
                addView(ImageView(context).apply {
                    setImageResource(R.drawable.user)
                })
                addView(EditText(context).apply {
                    R.id.versenyzoName2 = View.generateViewId()
                    id = R.id.versenyzoName2
                    hint = R.string.versenyzoName.toString()
                })
            })

            addView(LinearLayout(context).apply {
                orientation = LinearLayout.HORIZONTAL
                setPadding(12, 12, 12, 12)
                addView(ImageView(context).apply {
                    setImageResource(R.drawable.school2)
                })
                addView(EditText(context).apply {
                    R.id.versenyzoName3 = View.generateViewId()
                    id = R.id.versenyzoName3
                    hint = R.string.versenyzoGrade.toString()
                })
            })
        }
    }

    private fun getTeamMateDataUIGenerator3(): LinearLayout {
        return LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL

            addView(LinearLayout(context).apply {
                orientation = LinearLayout.HORIZONTAL
                setPadding(12, 12, 12, 12)
                addView(ImageView(context).apply {
                    setImageResource(R.drawable.user)
                })
                addView(EditText(context).apply {
                    R.id.versenyzoName1 = View.generateViewId()
                    id = R.id.versenyzoName1
                    hint = R.string.versenyzoName.toString()
                })
            })

            addView(LinearLayout(context).apply {
                orientation = LinearLayout.HORIZONTAL
                setPadding(12, 12, 12, 12)
                addView(ImageView(context).apply {
                    setImageResource(R.drawable.school2)
                })
                addView(EditText(context).apply {
                    R.id.versenyzoName1 = View.generateViewId()
                    id = R.id.versenyzoName1
                    hint = R.string.versenyzoGrade.toString()
                })
            })
        }
    }
}