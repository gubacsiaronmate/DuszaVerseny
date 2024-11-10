package com.gubo.duszaverseny

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.gubo.duszaverseny.components.DropdownHelper
import com.gubo.duszaverseny.database.configureDatabase
import com.gubo.duszaverseny.databinding.ActivityMainBinding
import com.gubo.duszaverseny.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        configureDatabase()

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.selector.setOnClickListener {
            DropdownHelper().showDropdown(this, binding.selector) { chosenActivity ->
                viewModel.updateChosenActivity(chosenActivity)
            }
            Log.d("Test", "(MainActivity) chosenActivity: ${viewModel.chosenActivity.value}")
        }

        binding.loginButton.setOnClickListener {
            viewModel.updateIsLogin(true)
            val intent = viewModel.getIntentFromActivityName(this)

            Log.d("Test", "intent: $intent")

            if (intent != null)
                viewModel.updateIntent(intent)
            else return@setOnClickListener

            Log.d("Test", "viewModel.intent: ${viewModel.intent.value}")

            viewModel.start(this)
        }

        binding.registerButton.setOnClickListener {
            viewModel.updateIsLogin(false)
            val intent = viewModel.getIntentFromActivityName(this)

            Log.d("Test", "intent: $intent")

            if (intent != null)
                viewModel.updateIntent(intent)
            else return@setOnClickListener

            Log.d("Test", "viewModel.intent: ${viewModel.intent.value}")

            viewModel.start(this)
        }
    }
}