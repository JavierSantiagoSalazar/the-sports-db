package com.javierestudio.thesportsdb.ui.detailsModule

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.javierestudio.appsosafe.framework.utils.TypeError
import com.javierestudio.thesportsdb.core.domain.league.model.Team
import com.javierestudio.thesportsdb.core.domain.matches.model.Matches
import com.javierestudio.thesportsdb.R
import com.javierestudio.thesportsdb.databinding.FragmentDetailsBinding
import com.javierestudio.thesportsdb.framework.utils.loadImageFromUrl
import com.javierestudio.thesportsdb.ui.detailsModule.adapters.MatchAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private lateinit var mBinding: FragmentDetailsBinding
    private val mDetailsViewModel: DetailsViewModel by viewModels()
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDetailsBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupTeamData()
        setupLinks()
    }

    private fun setupLinks() {
        with(mBinding){
            tvTeamWebPage.movementMethod = LinkMovementMethod.getInstance()
            tvTeamFacebook.movementMethod = LinkMovementMethod.getInstance()
            tvTeamInstagram.movementMethod = LinkMovementMethod.getInstance()
            tvTeamTwitter.movementMethod = LinkMovementMethod.getInstance()
        }
    }

    private fun setupTeamData() {
        with(mBinding){
            tvTeamDescription.movementMethod = ScrollingMovementMethod()

            tvTeamName.text = args.team.strTeam
            tvFoundationYear.text = args.team.intFormedYear
            tvTeamDescription.text = args.team.strDescriptionEn
            tvTeamWebPage.text = args.team.strWebsite?: getString(R.string.no_web_data)
            tvTeamFacebook.text = args.team.strFacebook?: getString(R.string.no_web_data)
            tvTeamTwitter.text = args.team.strTwitter?: getString(R.string.no_web_data)
            tvTeamInstagram.text = args.team.strInstagram?: getString(R.string.no_web_data)
            imgBadge.loadImageFromUrl(args.team.strTeamBadge)
            imgJersey.loadImageFromUrlc(args.team.strTeamJersey)
        }
    }

    private fun setupViewModel() {

        mDetailsViewModel.matchesResponse.observe(viewLifecycleOwner) { matchesList ->
            setAdapters(matchesList)
        }

        mDetailsViewModel.isVisible.observe(viewLifecycleOwner) { isVisible ->
            showProgressBar(isVisible)
        }

        mDetailsViewModel.typeError.observe(viewLifecycleOwner) { typeError ->
            showError(typeError)
        }

        mDetailsViewModel.getAllMatches(args.team.idTeam)
    }

    private fun setAdapters(matchList: List<Matches>) {
        mBinding.recyclerMatches.run {
            setHasFixedSize(true)
            adapter = MatchAdapter(matchList)
        }
    }

    private fun showProgressBar(isVisible: Boolean) {
        mBinding.progressBar.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    private fun showError(typeError: TypeError) {
        val msgRes = when (typeError) {
            TypeError.GET -> getString(R.string.main_error_get)
            else -> getString(R.string.main_error_unkown)
        }
        Snackbar.make(mBinding.root, msgRes, Snackbar.LENGTH_SHORT).show()
    }
}