package com.pince.pokexactivity.base

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.reflect.KProperty

/**
 * @Author Yu
 * @Date 2021/7/13 11:19
 * @Description
 */
@BindingPropertyDelegate
fun <T> StateFlow<T>.asBindingProperty() = StateFlowBindingPropertyId(this)

class StateFlowBindingPropertyId<T> constructor(private val stateFlow: StateFlow<T>) {
    operator fun provideDelegate(
        bindingViewModel: BindingViewModel,
        property: KProperty<*>
    ): Delegate<T> {
        val delegate = Delegate(stateFlow, property.bindingId())
        delegate.collect(bindingViewModel)
        return delegate
    }

    class Delegate<T>(private val stateFlow: StateFlow<T>, private val bindingId: Int) {
        fun collect(bindingViewModel:BindingViewModel){
            bindingViewModel.viewModelScope.launch {
                stateFlow.collect {
                    bindingViewModel.notifyPropertyChanged(bindingId)
                }
            }
        }
        operator fun getValue(thisRef: Any, property: KProperty<*>): T = stateFlow.value
    }
}
