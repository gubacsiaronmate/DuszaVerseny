package com.gubo.duszaverseny

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.gubo.duszaverseny.databinding.ActivityVersenyzoiRegisterBinding
import com.gubo.duszaverseny.viewModels.VersenyzoiRegisterViewModel

class VersenyzoiRegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVersenyzoiRegisterBinding
    private val viewModel: VersenyzoiRegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityVersenyzoiRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewModel = viewModel

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.addTeamMate.setOnClickListener {

        }
    }

    private fun getTeamMateDataUIGenerator(): LinearLayout {
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL

            addView(LinearLayout(this@VersenyzoiRegisterActivity).apply {
                orientation = LinearLayout.HORIZONTAL
                setPadding(12, 12, 12, 12)
                addView(ImageView(this@VersenyzoiRegisterActivity).apply {
                    setImageResource(R.drawable.user)
                })
                addView(EditText(this@VersenyzoiRegisterActivity).apply {
                    hint = R.string.versenyzoName.toString()
                })
            })
            addView(LinearLayout(this@VersenyzoiRegisterActivity).apply {
                orientation = LinearLayout.HORIZONTAL
                setPadding(12, 12, 12, 12)
                addView(ImageView(this@VersenyzoiRegisterActivity).apply {
                    setImageResource(R.drawable.school2)
                })
                addView(EditText(this@VersenyzoiRegisterActivity).apply {
                    hint = R.string.versenyzoGrade.toString()
                })
            })
        }
    }
}