package com.javierestudio.thesportsdb.ui.teamModule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.javierestudio.thesportsdb.databinding.ActivityTeamBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamActivity() : AppCompatActivity() {

    private lateinit var mBinding: ActivityTeamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityTeamBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}