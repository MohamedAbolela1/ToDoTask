package com.ibtikar.todolisttask.ui.base.presentation

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<item> : RecyclerView.Adapter<BaseViewHolder<item>>() {
    protected var data: MutableList<item> = arrayListOf()

    fun insertAll(insertedItemList: MutableList<item>) {
        data.clear()
        data.addAll(insertedItemList)
        notifyDataSetChanged()
    }
}
