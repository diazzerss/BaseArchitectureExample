package ru.diazzerss.recycler_view_example.presentation.producers

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.diazzerss.presentation.base.recycler_view.ViewHolderProducer
import ru.diazzerss.recycler_view_example.databinding.ItemTitleBinding
import ru.diazzerss.recycler_view_example.presentation.producers.ItemType.RV_TITLE
import ru.diazzerss.recycler_view_example.presentation.view_model.TitleViewModel

class TitleViewHolderProducer : ViewHolderProducer<String, TitleViewModel, ItemTitleBinding>(
    RV_TITLE, String::class.java, TitleViewModel::class.java) {

    override fun initBinding(inflater: LayoutInflater, parent: ViewGroup): ItemTitleBinding =
        ItemTitleBinding.inflate(inflater, parent, false)
}