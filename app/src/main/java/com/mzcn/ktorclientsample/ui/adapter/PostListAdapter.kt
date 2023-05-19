package com.mzcn.ktorclientsample.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.mzcn.ktorclientsample.databinding.ItemRecyclerRowBinding
import com.mzcn.ktorclientsample.network.dto.PostModel

class PostListAdapter : ListAdapter<PostModel, PostModelViewHolder>(PostListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostModelViewHolder {
        return PostModelViewHolder(
            ItemRecyclerRowBinding.inflate(
                LayoutInflater.from(
                    parent.context,
                ),
                parent,
                false
            )

        )
    }

    override fun onBindViewHolder(holder: PostModelViewHolder, position: Int) {

        val postModel = getItem(position)

        holder.bind(postModel)
    }
}