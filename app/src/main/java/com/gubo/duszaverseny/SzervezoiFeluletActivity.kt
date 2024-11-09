package com.gubo.duszaverseny

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.gubo.duszaverseny.databinding.ActivitySzervezoiFeluletBinding
import com.gubo.duszaverseny.viewModels.SzervezoiFeluletViewModel

class SzervezoiFeluletActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySzervezoiFeluletBinding
    private val viewModel: SzervezoiFeluletViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySzervezoiFeluletBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewModel = viewModel
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}