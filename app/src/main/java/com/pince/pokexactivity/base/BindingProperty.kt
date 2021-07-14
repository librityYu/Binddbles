package com.pince.pokexactivity.base

import kotlin.reflect.KProperty

/**
 * @Author Yu
 * @Date 2021/7/13 11:44
 * @Description TODO
 */
@BindingPropertyDelegate
fun <T> bindingProperty(defaultValue: T) =
    BindingPropertyIdWithDefaultValue(defaultValue)

class BindingPropertyIdWithDefaultValue<T>(private var value: T) {
    operator fun getValue(bindingObservable: BindingObservable, property: KProperty<*>): T = value
    operator fun setValue(bindingObservable: BindingObservable, property: KProperty<*>, value: T) {
        if (this.value != value) {
            this.value = value
            bindingObservable.notifyPropertyChanged(property.bindingId())
        }
    }
}