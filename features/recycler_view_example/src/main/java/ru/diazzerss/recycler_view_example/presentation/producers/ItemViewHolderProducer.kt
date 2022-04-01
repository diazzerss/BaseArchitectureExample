package ru.diazzerss.recycler_view_example.presentation.producers

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.diazzerss.presentation.base.recycler_view.ViewHolderProducer
import ru.diazzerss.recycler_view_example.databinding.ItemExample1Binding
import ru.diazzerss.recycler_view_example.presentation.producers.ItemType.RV_ITEM
import ru.diazzerss.recycler_view_example.presentation.view_model.ItemViewModel

class ItemViewHolderProducer : ViewHolderProducer<String, ItemViewModel, ItemExample1Binding> (RV_ITEM, String::class.java, ItemViewModel::class.java) {
    override fun initBinding(inflater: LayoutInflater, parent: ViewGroup) =
        ItemExample1Binding.inflate(inflater, parent, false)
}