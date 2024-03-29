package ru.diazzerss.recycler_view_example.presentation.view_model

import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.MutableStateFlow
import ru.diazzerss.presentation.base.recycler_view.RecyclerViewBaseItem
import ru.diazzerss.presentation.extensions.launchWhenStarted
import ru.diazzerss.recycler_view_example.databinding.ItemTitleBinding

class TitleViewModel : RecyclerViewBaseItem<String, ItemTitleBinding>() {
    private val title = MutableStateFlow("")

    override fun initVars() {
        title.launchWhenStarted(parent.lifecycleScope) {
            binding.title.text = it
        }
    }

    override fun bindData(data: String) {
        title.value = data
    }
}