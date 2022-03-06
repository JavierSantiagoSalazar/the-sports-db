package com.javierestudio.thesportsdb.framework.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.javierestudio.thesportsdb.framework.database.daos.TeamDao
import com.javierestudio.thesportsdb.framework.database.entities.TeamEntity

@Database(entities = [TeamEntity::class], version = 1)
abstract class TeamDatabase: RoomDatabase() {
    abstract fun teamDao(): TeamDao
}