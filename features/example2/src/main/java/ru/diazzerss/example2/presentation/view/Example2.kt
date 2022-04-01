package ru.diazzerss.example2.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import ru.diazzerss.example2.databinding.FragmentExample2Binding
import ru.diazzerss.example2.di.components.Example2Component
import ru.diazzerss.example2.presentation.view_model.Example2ViewModel
import ru.diazzerss.presentation.base.BaseApplication
import ru.diazzerss.presentation.base.BaseFragment
import ru.diazzerss.presentation.extensions.launchWhenStarted

class Example2 : BaseFragment<Example2ViewModel, FragmentExample2Binding>(Example2ViewModel::class.java) {

    override fun inject(app: BaseApplication) {
        app.getComponent<Example2Component>().inject(this)
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentExample2Binding.inflate(inflater, container, false)

    override fun initVars() {
        viewModel.isLoading.launchWhenStarted(lifecycleScope) {
            binding.pbLoading.visibility = if (it) View.VISIBLE else View.INVISIBLE
            binding.text.visibility = if (it) View.INVISIBLE else View.VISIBLE
        }

        viewModel.text.launchWhenStarted(lifecycleScope) {
            binding.text.text = it
        }
    }

    override fun setListeners() {
        //TODO("Not yet implemented")
    }
}