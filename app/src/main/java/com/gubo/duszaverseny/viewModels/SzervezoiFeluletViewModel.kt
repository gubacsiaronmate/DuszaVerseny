package com.gubo.duszaverseny.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gubo.duszaverseny.data.Category
import com.gubo.duszaverseny.data.ProgLang
import kotlinx.datetime.LocalDateTime

class SzervezoiFeluletViewModel() : ViewModel() {
    private val _deadline = MutableLiveData<LocalDateTime>()
    val deadline: LiveData<LocalDateTime> get() = _deadline

    private val _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>> get() = _categories

    private val _progLangs = MutableLiveData<List<ProgLang>>()
    val progLangs: LiveData<List<ProgLang>> get() = _progLangs

    fun updateDeadline(newDeadline: LocalDateTime) {
        _deadline.value = newDeadline
    }

    fun updateCategories(newCategories: List<Category>) {
        _categories.value = newCategories
    }

    fun updateProgLangs(newProgLangs: List<ProgLang>) {
        _progLangs.value = newProgLangs
    }
}