package com.jhonjto.thecatapi.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jhonjto.domain.CatListItem
import com.jhonjto.thecatapi.ui.common.ScopedViewModel
import com.jhonjto.usecases.GetCatList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getCatList: GetCatList): ScopedViewModel() {

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) callService()
            return _model
        }

    sealed class UiModel {
        object Loading : UiModel()
        class Content(val cats: List<CatListItem>) : UiModel()
    }

    init {
        initScope()
    }

    private fun callService() {
        launch {
            _model.value = UiModel.Loading
            _model.value = UiModel.Content(getCatList.invoke())
        }
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }
}