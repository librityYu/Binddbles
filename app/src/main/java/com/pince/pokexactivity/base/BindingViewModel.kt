package com.pince.pokexactivity.base

import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModel
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty

/**
 * @Author Yu
 * @Date 2021/7/9 9:56
 * @Description TODO
 */
open class BindingViewModel : ViewModel(), BindingObservable {
    private val lock: Any = Any()

    // 用于保存和通知可绑定属性更改的回调注册表
    private var propertyCallbacks: PropertyChangeRegistry? = null
    override fun notifyPropertyChanged(property: KProperty<*>) {
        synchronized(lock) lock@{
            val propertyCallbacks = propertyCallbacks ?: return@lock
            propertyCallbacks.notifyCallbacks(this, property.bindingId(), null)
        }
    }

    override fun notifyPropertyChanged(function: KFunction<*>) {
        synchronized(lock) lock@{
            val propertyCallbacks = propertyCallbacks ?: return@lock
            propertyCallbacks.notifyCallbacks(this, function.bindingId(), null)
        }
    }

    override fun notifyPropertyChanged(bindingId: Int) {
        synchronized(lock) lock@{
            val propertyCallbacks = propertyCallbacks ?: return@lock
            propertyCallbacks.notifyCallbacks(this, bindingId, null)
        }
    }

    override fun notifyAllPropertiesChanged() {
        synchronized(lock) lock@{
            val propertyCallbacks = propertyCallbacks ?: return@lock
            propertyCallbacks.notifyCallbacks(this, BR._all, null)
        }
    }

    override fun clearAllProperties() {
        synchronized(lock) lock@{
            val propertyCallbacks = propertyCallbacks ?: return@lock
            propertyCallbacks.clear()
        }
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        synchronized(lock) lock@{
            val propertyCallbacks = propertyCallbacks
                ?: PropertyChangeRegistry().also { propertyChangeRegistry ->
                    propertyCallbacks = propertyChangeRegistry
                }
            propertyCallbacks.add(callback)
        }
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        synchronized(lock) lock@{
            val propertyCallbacks = propertyCallbacks ?: return@lock
            propertyCallbacks.remove(callback)
        }
    }

    override fun onCleared() {
        super.onCleared()
        clearAllProperties()
    }
}