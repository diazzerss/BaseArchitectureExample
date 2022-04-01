package ru.diazzerss.recycler_view_example.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import ru.diazzerss.presentation.base.BaseApplication
import ru.diazzerss.presentation.base.BaseFragment
import ru.diazzerss.presentation.base.recycler_view.RecyclerViewAdapter
import ru.diazzerss.presentation.extensions.launchWhenStarted
import ru.diazzerss.recycler_view_example.databinding.FragmentRecyclerViewExampleBinding
import ru.diazzerss.recycler_view_example.di.components.RecyclerViewExampleComponent
import ru.diazzerss.recycler_view_example.presentation.producers.ItemViewHolderProducer
import ru.diazzerss.recycler_view_example.presentation.producers.TitleViewHolderProducer
import ru.diazzerss.recycler_view_example.presentation.view_model.RecyclerViewExampleViewModel

class RecyclerViewExample : BaseFragment<RecyclerViewExampleViewModel, FragmentRecyclerViewExampleBinding>(
    RecyclerViewExampleViewModel::class.java) {

    override fun inject(app: BaseApplication) {
        app.getComponent<RecyclerViewExampleComponent>().inject(this)
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentRecyclerViewExampleBinding.inflate(inflater, container, false)

    override fun initVars() {
        binding.rvExample.adapter = recyclerViewAdapter()

        viewModel.isLoading.launchWhenStarted(lifecycleScope) {
            binding.loadingPb.visibility = if (it) View.VISIBLE else View.INVISIBLE
            binding.rvExample.visibility = if (it) View.INVISIBLE else View.VISIBLE
        }
    }

    private fun recyclerViewAdapter() = RecyclerViewAdapter.Builder(this, viewModel.items)
        .addProducer(TitleViewHolderProducer())
        .addProducer(ItemViewHolderProducer())
        .build(viewModel::toRecyclerViewItems)
}