package com.javierestudio.thesportsdb.ui.teamModule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.javierestudio.thesportsdb.framework.utils.TypeError
import com.javierestudio.thesportsdb.R
import com.javierestudio.thesportsdb.core.domain.league.model.Team
import com.javierestudio.thesportsdb.databinding.FragmentTeamBinding
import com.javierestudio.thesportsdb.framework.utils.Constants
import com.javierestudio.thesportsdb.ui.teamModule.adapters.OnTeamClick
import com.javierestudio.thesportsdb.ui.teamModule.adapters.TeamAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamFragment : Fragment(), OnTeamClick {

    private lateinit var mBinding: FragmentTeamBinding
    private val mTeamViewModel: TeamViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentTeamBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupToggleGroup()
    }



    private fun setupToggleGroup() {
        mBinding.toggleButton.addOnButtonCheckedListener { group, checkedId, isChecked ->
            when(checkedId){
                R.id.btnLaLiga -> mTeamViewModel.getAllTeams(Constants.LA_LIGA)
                R.id.btnPremierLeague -> mTeamViewModel.getAllTeams(Constants.PREMIER)
                R.id.btnSerieA -> mTeamViewModel.getAllTeams(Constants.SERIE)
            }
        }
    }

    private fun setupViewModel() {


        mTeamViewModel.teamsResponse.observe(viewLifecycleOwner){ teamList ->
            setAdapters(teamList)
        }

        mTeamViewModel.isVisible.observe(viewLifecycleOwner){ isVisible ->
            showProgressBar(isVisible)
        }

        mTeamViewModel.typeError.observe(viewLifecycleOwner) { typeError ->
            showError(typeError)
        }
    }

    private fun setAdapters(teamList: List<Team>) {
        mBinding.recycler.run{
            setHasFixedSize(true)
            adapter = TeamAdapter(teamList, this@TeamFragment)
        }
    }

    private fun showProgressBar(isVisible: Boolean){
        mBinding.progressBar.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    private fun showError(typeError: TypeError){
        val msgRes = when(typeError){
            TypeError.GET -> getString(R.string.main_error_get)
            else -> getString(R.string.main_error_unknown)
        }
        Snackbar.make(mBinding.root, msgRes, Snackbar.LENGTH_SHORT).show()
    }

    override fun showTeamDetails(team: Team) {
        val action = TeamFragmentDirections.actionTeamFragmentToDetailsFragment(team)
        findNavController().navigate(action)
    }
}