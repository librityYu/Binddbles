package com.pince.pokexactivity.vm

import androidx.databinding.Bindable
import androidx.lifecycle.viewModelScope
import com.pince.pokexactivity.base.BindingViewModel
import com.pince.pokexactivity.base.asBindingProperty
import com.pince.pokexactivity.base.bindingProperty
import com.pince.pokexactivity.bean.MockUtil
import com.pince.pokexactivity.bean.Poster
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

/**
 * @Author Yu
 * @Date 2021/7/13 10:06
 * @Description TODO
 */
class MainViewModel : BindingViewModel() {
    private val stateFlow = MutableStateFlow(listOf<Poster>())

    @get:Bindable
    val data: List<Poster> by stateFlow.asBindingProperty()

    @get:Bindable
    var isLoading: Boolean by bindingProperty(false)
        private set

    @get:Bindable
    var toast: String? by bindingProperty(null)
        private set

    init {
        viewModelScope.launch {
            isLoading = true
            delay(2000)
            stateFlow.emit(MockUtil.getMockPosters())
            isLoading = false
            toast = "finished loading data"
        }
    }
}