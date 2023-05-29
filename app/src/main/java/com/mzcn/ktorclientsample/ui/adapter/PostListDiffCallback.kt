package com.mzcn.ktorclientsample.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.mzcn.ktorclientsample.network.model.Post

class PostListDiffCallback : DiffUtil.ItemCallback<Post>() {

    override fun areItemsTheSame(oldItem: Post, newItem: Post) =
        (oldItem.id == newItem.id)

    override fun areContentsTheSame(oldItem: Post, newItem: Post) =
        (oldItem == newItem)
}