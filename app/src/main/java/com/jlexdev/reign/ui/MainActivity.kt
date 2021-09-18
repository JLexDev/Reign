package com.jlexdev.reign.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jlexdev.reign.BR
import com.jlexdev.reign.R
import com.jlexdev.reign.base.BaseActivity
import com.jlexdev.reign.databinding.ActivityMainBinding
import com.jlexdev.reign.ui.adapter.HitsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator {

    private val mainViewModel: MainViewModel by viewModel()

    override val _viewModel: MainViewModel
        get() = mainViewModel
    override val getViewModel: MainViewModel
        get() = _viewModel
    override val getLayoutId = R.layout.activity_main
    override val getBindingVariable = BR.mainViewModel

    private lateinit var binding: ActivityMainBinding

    private val hitsAdapter = HitsAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.setNavigator(this)

        bindLayout()
        setupObserve()
        setupList()
    }

    private fun bindLayout() {
        this.binding = DataBindingUtil.setContentView(this, getLayoutId)
        this.binding.let {
            it.lifecycleOwner = this
        }
    }

    private fun setupObserve() {
        _viewModel.reign.observe(this, Observer {
            hitsAdapter.addItems(it.hits)
        })
    }

    private fun setupList() {
        this.binding.rvList.apply {
            adapter = hitsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    override fun navigateToWeb() {
        /*startActivity(Intent(this, WebActivity::class.java))
        finish()*/
    }
}