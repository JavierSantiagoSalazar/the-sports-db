package com.javierestudio.thesportsdb.framework.di

import android.content.Context
import androidx.room.Room
import com.javierestudio.thesportsdb.framework.database.TeamDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context,
            TeamDatabase::class.java,
            "TeamDatabase")
            .build()
}