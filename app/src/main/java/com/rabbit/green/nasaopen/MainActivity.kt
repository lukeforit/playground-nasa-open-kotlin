package com.rabbit.green.nasaopen

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        var binding: ViewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setVariable(BR.vm, presenter.viewModel)
        presenter.setup()
    }

}
