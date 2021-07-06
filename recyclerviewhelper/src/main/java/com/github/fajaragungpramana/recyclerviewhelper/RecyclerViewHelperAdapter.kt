package com.github.fajaragungpramana.recyclerviewhelper

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class RecyclerViewHelperAdapter<VB : ViewBinding, E : Any>(diffUtil: DiffUtil.ItemCallback<E>) :
    ListAdapter<E, RecyclerViewHelperAdapter.ViewHolder<VB>>(diffUtil) {

    protected abstract fun onCreateViewBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): VB

    protected abstract fun onPrepareBindViewHolder(binding: ViewBinding, entity: E?, position: Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<VB> =
        ViewHolder(onCreateViewBinding(LayoutInflater.from(parent.context), parent, viewType))

    override fun onBindViewHolder(holder: ViewHolder<VB>, position: Int) {
        onPrepareBindViewHolder(holder.binding, getItem(position), position)
    }

    class ViewHolder<VB : ViewBinding>(val binding: VB) : RecyclerView.ViewHolder(binding.root)

}