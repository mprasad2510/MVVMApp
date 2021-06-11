package com.cybage.mvvmnewsapp.features

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cybage.mvvmnewsapp.databinding.ActivityDataBinding
import com.cybage.mvvmnewsapp.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DataActivity : AppCompatActivity() {

    private val viewModel : DataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataListAdapter = DataListAdapter()

        binding.apply {
            recyclerView.apply {
                adapter = dataListAdapter
                layoutManager = LinearLayoutManager(this@DataActivity)
            }

              viewModel.data.observe(this@DataActivity) { result ->
              dataListAdapter.submitList(result.data)

                progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
                textViewError.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
                textViewError.text = result.error?.localizedMessage
            }
        }
    }
}