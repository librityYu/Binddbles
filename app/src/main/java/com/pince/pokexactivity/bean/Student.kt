package com.pince.pokexactivity.bean

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.library.baseAdapters.BR

/**
 * @Author Yu
 * @Date 2021/7/9 10:25
 * @Description TODO
 */
class Student : BaseObservable {

    @Bindable
    var name: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)

        }
    var id: Int = 1

    constructor(name: String, id: Int) {
        this.name = name
        this.id = id
    }


}