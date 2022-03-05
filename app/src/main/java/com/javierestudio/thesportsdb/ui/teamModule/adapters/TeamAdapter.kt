package com.javierestudio.thesportsdb.ui.teamModule.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.javierestudio.core.domain.league.model.Team
import com.javierestudio.thesportsdb.databinding.ItemTeamBinding
import com.javierestudio.thesportsdb.framework.utils.loadImageFromUrl
import com.javierestudio.thesportsdb.framework.utils.loadImageFromUrlCenterCrop

class TeamAdapter(private val teamsList: List<Team>) :RecyclerView.Adapter<TeamAdapter.ViewHolder>(){

    inner class ViewHolder(private val binding: ItemTeamBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(team: Team) {
            with(binding) {
                tvName.text = team.strTeam
                tvStadium.text = team.strStadium
                imgPhoto.loadImageFromUrl(team.strTeamBadge)
                imgStadium.loadImageFromUrlCenterCrop(team.strStadiumThumb)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemTeamBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val team = teamsList[position]
        holder.bind(team)
    }

    override fun getItemCount(): Int = teamsList.size

}