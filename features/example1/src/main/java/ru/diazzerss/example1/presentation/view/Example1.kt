package ru.diazzerss.example1.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import ru.diazzerss.example1.databinding.FragmentExample1Binding
import ru.diazzerss.example1.di.components.Example1Component
import ru.diazzerss.example1.presentation.view.NavActions.OPEN_EXAMPLE_2
import ru.diazzerss.example1.presentation.view_model.Example1ViewModel
import ru.diazzerss.presentation.base.BaseApplication
import ru.diazzerss.presentation.base.BaseFragment
import ru.diazzerss.presentation.extensions.launchWhenStarted
import ru.diazzerss.presentation.navigation.UiAction

class Example1 : BaseFragment<Example1ViewModel, FragmentExample1Binding>(Example1ViewModel::class.java) {
    override fun inject(app: BaseApplication) {
        app.getComponent<Example1Component>().inject(this)
    }

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentExample1Binding.inflate(inflater, container, false)

    override fun initVars() {
        viewModel.result.launchWhenStarted(lifecycleScope) {
            binding.text.text = it
        }
    }

    override fun setListeners() {
        binding.nextBtn.setOnClickListener {
            navigator.navigateTo(UiAction(OPEN_EXAMPLE_2))
        }
    }
}