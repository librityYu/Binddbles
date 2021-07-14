package com.pince.pokexactivity.base

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * @Author Yu
 * @Date 2021/7/9 9:14
 * @Description TODO
 */
abstract class BindingActivity<T : ViewDataBinding> public constructor(contentLayoutId: Int) :
    AppCompatActivity() {
    init {
        addOnContextAvailableListener {
            binding.notifyChange()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }

    protected var bindingComponent: androidx.databinding.DataBindingComponent? =
        DataBindingUtil.getDefaultComponent()
    @BindingOnly
    protected val binding: T by lazy(LazyThreadSafetyMode.NONE) {
        DataBindingUtil.setContentView(
            this,
            contentLayoutId,
            bindingComponent
        )
    }
    @BindingOnly
    protected inline fun binding(block:T.()->Unit):T{
        return binding.apply(block)
    }


}