package com.example.homework4_android3.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel>(@LayoutRes val layoutRes: Int) :
    Fragment(layoutRes) {

    abstract val binding: VB
    abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
        setupListeners()
        setupSubscribes()
        setupRequests()
    }

    protected open fun initialize() {}

    protected open fun setupListeners() {}

    protected open fun setupSubscribes() {}

    protected open fun setupRequests() {}
}