package com.github.fajaragungpramana.recyclerviewhelper

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.viewbinding.ViewBinding

class RecyclerViewHelperAdapterImpl<E : Any>(
    diffUtil: DiffUtil.ItemCallback<E>,
    private inline val mOnEachItemViewType: (data: E?) -> Int,
    private inline val mOnCreateViewBinding: (inflater: LayoutInflater, parent: ViewGroup, viewType: Int) -> ViewBinding?,
    private inline val mOnBinding: (binding: ViewBinding, entity: E?, position: Int) -> Unit
) : RecyclerViewHelperAdapter<ViewBinding, E>(diffUtil) {

    constructor(
        diffUtil: DiffUtil.ItemCallback<E>,
        onCreateViewBinding: (
            inflater: LayoutInflater,
            parent: ViewGroup,
            viewType: Int
        ) -> ViewBinding? = { _, _, _ -> null },
        onBinding: (binding: ViewBinding, entity: E?, position: Int) -> Unit = { _, _, _ -> }
    ) : this(diffUtil, { 0 }, onCreateViewBinding, onBinding)

    override fun onCreateViewBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): ViewBinding = mOnCreateViewBinding(inflater, parent, viewType) ?: throw NullPointerException(
        "Invalid to inflate adapter."
    )

    override fun onPrepareBindViewHolder(binding: ViewBinding, entity: E?, position: Int) {
        mOnBinding(binding, getItem(position), position)
    }

    override fun getItemViewType(position: Int) = mOnEachItemViewType(getItem(position))

}