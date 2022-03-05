package com.javierestudio.thesportsdb.ui.teamModule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.javierestudio.appsosafe.framework.utils.TypeError
import com.javierestudio.core.data.TeamsRepositoryImpl
import com.javierestudio.core.domain.league.model.Team
import com.javierestudio.core.domain.league.usecases.GetTeams
import com.javierestudio.thesportsdb.R
import com.javierestudio.thesportsdb.databinding.ActivityTeamBinding
import com.javierestudio.thesportsdb.framework.network.datasource.TeamsRemoteDataSourceImpl
import com.javierestudio.thesportsdb.framework.network.services.APIService
import com.javierestudio.thesportsdb.ui.teamModule.adapters.TeamAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamActivity() : AppCompatActivity() {

    private lateinit var mBinding: ActivityTeamBinding
    private val mTeamViewModel: TeamViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityTeamBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setupViewModel()

    }

    private fun setupViewModel() {
        mTeamViewModel.getAllTeams()

        mTeamViewModel.teamsResponse.observe(this){ teamList ->
            setAdapters(teamList)
        }

        mTeamViewModel.isVisible.observe(this){ isVisible ->
           showProgressBar(isVisible)
        }

        mTeamViewModel.typeError.observe(this) { typeError ->
            showError(typeError)
        }
    }

    private fun setAdapters(teamList: List<Team>) {
        mBinding.recycler.run{
            setHasFixedSize(true)
            adapter = TeamAdapter(teamList)
        }
    }

    private fun showProgressBar(isVisible: Boolean){
        mBinding.progressBar.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    private fun showError(typeError: TypeError){
        val msgRes = when(typeError){
            TypeError.GET -> getString(R.string.main_error_get)
            else -> getString(R.string.main_error_unkown)
        }
        Snackbar.make(mBinding.root, msgRes, Snackbar.LENGTH_SHORT).show()
    }
}