package com.jlexdev.reign.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

abstract class BaseActivity<T: ViewDataBinding, out V : BaseViewModel> : AppCompatActivity() {

    private lateinit var viewDataBinding: T

    abstract val _viewModel: V

    abstract val getLayoutId : Int

    abstract val getViewModel : V

    abstract val getBindingVariable : Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId)
        viewDataBinding.setVariable(getBindingVariable, _viewModel)

        viewDataBinding.lifecycleOwner = this
        viewDataBinding.executePendingBindings()
    }

}