package com.cybage.mvvmnewsapp.features

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cybage.mvvmnewsapp.data.DataAnnually
import com.cybage.mvvmnewsapp.databinding.ItemRowBinding

class DataListAdapter : ListAdapter<DataAnnually, DataListAdapter.DataViewHolder>(DataComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class DataViewHolder(private val binding: ItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(data: DataAnnually) {
                binding.apply {
                    txtData.text = data.volume_of_mobile_data.toString()
                }
            }
        }

     class DataComparator : DiffUtil.ItemCallback<DataAnnually>() {

         override fun areItemsTheSame(oldItem: DataAnnually, newItem: DataAnnually): Boolean =
             oldItem.volume_of_mobile_data == newItem.volume_of_mobile_data

         override fun areContentsTheSame(oldItem: DataAnnually, newItem: DataAnnually): Boolean =
           oldItem == newItem

     }
}

