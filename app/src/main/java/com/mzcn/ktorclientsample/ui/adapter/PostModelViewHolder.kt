package com.mzcn.ktorclientsample.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.mzcn.ktorclientsample.databinding.ItemRecyclerRowBinding
import com.mzcn.ktorclientsample.network.model.Post

class PostModelViewHolder(private val binding: ItemRecyclerRowBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(postModel: Post) = with(binding) {

        tvPostId.text = postModel.id.toString()
        tvPostBody.text = postModel.body
    }
}