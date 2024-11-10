package com.gubo.duszaverseny.viewModels

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gubo.duszaverseny.IskolaiLoginActivity
import com.gubo.duszaverseny.IskolaiRegisterActivity
import com.gubo.duszaverseny.R
import com.gubo.duszaverseny.SzervezoiLoginActivity
import com.gubo.duszaverseny.SzervezoiRegisterActivity
import com.gubo.duszaverseny.VersenyzoiLoginActivity
import com.gubo.duszaverseny.VersenyzoiRegisterActivity

class MainViewModel : ViewModel() {
    private val _intent = MutableLiveData<Intent>()
    val intent: MutableLiveData<Intent> = _intent

    private val _chosenActivity = MutableLiveData<String>()
    val chosenActivity: MutableLiveData<String> = _chosenActivity

    private val _isLogin = MutableLiveData<Boolean>()
    val isLogin: MutableLiveData<Boolean> = _isLogin

    fun updateIsLogin(isLogin: Boolean) {
        _isLogin.value = isLogin
    }

    fun updateChosenActivity(activityName: String) {
        _chosenActivity.value = activityName
    }

    fun getIntentFromActivityName(context: Context): Intent? {
        Log.d("Test", "(MainViewModel) Chosen activity: ${chosenActivity.value}")
        return if (isLogin.value!!) when (chosenActivity.value) {
            context.getString(R.string.versenyzoi) -> Intent(context, VersenyzoiLoginActivity::class.java)
            context.getString(R.string.szervezoi) -> Intent(context, SzervezoiLoginActivity::class.java)
            context.getString(R.string.iskolai) -> Intent(context, IskolaiLoginActivity::class.java)
            else -> null
        } else when (chosenActivity.value) {
            context.getString(R.string.versenyzoi) -> Intent(context, VersenyzoiRegisterActivity::class.java)
            context.getString(R.string.szervezoi) -> Intent(context, SzervezoiRegisterActivity::class.java)
            context.getString(R.string.iskolai) -> Intent(context, IskolaiRegisterActivity::class.java)
            else -> null
        }
    }


    fun updateIntent(intent: Intent) {
        _intent.value = intent
    }

    fun start(context: Context) {
        val intentLocal = intent.value ?: return
        context.startActivity(intentLocal)
    }
}