package com.javierestudio.thesportsdb.ui.detailsModule.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.javierestudio.thesportsdb.core.domain.matches.model.Matches
import com.javierestudio.thesportsdb.databinding.ItemMatchesBinding

class MatchAdapter(private val matchList: List<Matches>) :
    RecyclerView.Adapter<MatchAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemMatchesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(match: Matches) {
            with(binding) {
                binding.tvNameMatch.text = match.strEvent
                binding.tvDateMatch.text = match.dateEvent
                binding.tvTimeMatch.text = match.strTime
                binding.tvStadiumMatch.text = match.strVenue
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMatchesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val match = matchList[position]
        holder.bind(match)
    }

    override fun getItemCount(): Int = matchList.size
}