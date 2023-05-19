package com.mzcn.ktorclientsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mzcn.ktorclientsample.databinding.ActivityMainBinding
import com.mzcn.ktorclientsample.network.dto.PostModel
import com.mzcn.ktorclientsample.repository.RemoteRepository
import com.mzcn.ktorclientsample.ui.adapter.PostListAdapter
import dagger.hilt.android.AndroidEntryPoint
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var repository: RemoteRepository

    private val recyclerAdapter by lazy {
        PostListAdapter()
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() = with(binding) {

        rvPosts.adapter = recyclerAdapter

        CoroutineScope(Dispatchers.IO).launch {

            val response = repository.getPosts()

            withContext(Dispatchers.Main) {
                recyclerAdapter.submitList(response)
            }
        }
    }
}