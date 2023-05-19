package com.mzcn.ktorclientsample.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.mzcn.ktorclientsample.network.dto.PostModel

class PostListDiffCallback : DiffUtil.ItemCallback<PostModel>() {

    override fun areItemsTheSame(oldItem: PostModel, newItem: PostModel) =
        (oldItem.id == newItem.id)

    override fun areContentsTheSame(oldItem: PostModel, newItem: PostModel) =
        (oldItem == newItem)
}