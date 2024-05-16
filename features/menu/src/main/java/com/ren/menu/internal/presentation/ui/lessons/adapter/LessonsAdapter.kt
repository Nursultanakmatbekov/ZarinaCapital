package com.ren.menu.internal.presentation.ui.lessons.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ren.menu.databinding.ItemLessonsBinding
import com.ren.menu.databinding.ItemNewsBinding
import com.ren.menu.internal.domain.entities.news.News
import com.ren.menu.internal.domain.entities.schedule.Schedule
import com.ren.menu.internal.presentation.ui.news.adapters.NewsAdapter

class LessonsAdapter(val setItemClickListener: (id: Int) -> Unit) :
    ListAdapter<Schedule, LessonsAdapter.LessonsViewHolder>(diffUtil) {

    inner class LessonsViewHolder(private val binding: ItemLessonsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Schedule) {
            item.lessons?.map {
                binding.tvLesson.text = it.id.toString()
                binding.tvName.text = it.name
                binding.tvStartTime.text = it.startTime
                binding.tvEndTime.text = it.endTime
                item.lessons.map {itemLessons->
                    itemView.setOnClickListener {
                        getItem(adapterPosition)?.apply { setItemClickListener(itemLessons.id) }
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonsViewHolder {
        return LessonsViewHolder(
            ItemLessonsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: LessonsViewHolder, position: Int) {
        getItem(position).let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Schedule>() {
            override fun areItemsTheSame(
                oldItem: Schedule,
                newItem: Schedule
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: Schedule, newItem: Schedule
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}