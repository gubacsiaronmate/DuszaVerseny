package com.gubo.duszaverseny

import android.os.Bundle
import android.util.Log
import android.view.View
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
    private var teamMateNum: Int = 1

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

        R.id.versenyzoName1 = View.generateViewId()
        R.id.versenyzoName2 = View.generateViewId()
        R.id.versenyzoName3 = View.generateViewId()

        R.id.versenyzoGrade1 = View.generateViewId()
        R.id.versenyzoGrade2 = View.generateViewId()
        R.id.versenyzoGrade3 = View.generateViewId()

        viewModel.updateVersenyzok(mutableListOf())

        binding.addTeamMate.setOnClickListener {
            val vmvv = viewModel.versenyzok.value
            val size = vmvv?.size

            Log.d("Test", "vmvv: $vmvv")
            Log.d("Test", "size: $size")

            size?.let {
                if (it <= 4)
                    binding.teamMateBox.addView(
                        viewModel.getTeamMateDataUIGenerator(this)
                    )
                else binding.addTeamMate.visibility = View.GONE
            }
        }
    }
}