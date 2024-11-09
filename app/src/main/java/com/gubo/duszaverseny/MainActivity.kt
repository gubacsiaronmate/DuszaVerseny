package com.gubo.duszaverseny

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.gubo.duszaverseny.database.configureDatabase
import com.gubo.duszaverseny.databinding.ActivityMainBinding
import com.gubo.duszaverseny.mail.EmailSenderService
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureDatabase()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.startButton.setOnClickListener {
            lifecycleScope.launch {
                EmailSenderService(
                    "g.aronmate13@gmail.com",
                    "Dusza VersenyPortál",
                    "emailTemplate",
                    mapOf("code" to 569465)
                ).sendEmail()
            }
        }
    }
}