package com.javierestudio.thesportsdb.framework.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.javierestudio.thesportsdb.framework.database.entities.TeamEntity

@Dao
interface TeamDao {

    @Query("SELECT * FROM TeamEntity")
    fun getTeams(): List<TeamEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTeams(teams: List<TeamEntity>)
}