package com.pince.pokexactivity.base

import androidx.databinding.Observable
import java.util.*
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty

/**
 * @Author Yu
 * @Date 2021/7/9 9:57
 * @Description TODO
 */
interface BindingObservable:Observable {
    fun notifyPropertyChanged(property:KProperty<*>)
    fun notifyPropertyChanged(function:KFunction<*>)
    fun clearAllProperties()
    fun notifyPropertyChanged(bindingId: Int)
    fun notifyAllPropertiesChanged()
}