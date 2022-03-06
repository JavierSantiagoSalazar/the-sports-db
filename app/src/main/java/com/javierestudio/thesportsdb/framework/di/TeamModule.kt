package com.javierestudio.thesportsdb.framework.di

import com.javierestudio.thesportsdb.core.data.teams.TeamsLocalDataSource
import com.javierestudio.thesportsdb.core.data.teams.TeamsRemoteDataSource
import com.javierestudio.thesportsdb.core.data.teams.TeamsRepositoryImpl
import com.javierestudio.thesportsdb.core.domain.league.repository.TeamsRepository
import com.javierestudio.thesportsdb.framework.database.TeamDatabase
import com.javierestudio.thesportsdb.framework.database.daos.TeamDao
import com.javierestudio.thesportsdb.framework.database.datasource.TeamsLocalDataSourceImpl
import com.javierestudio.thesportsdb.framework.network.datasource.TeamsRemoteDataSourceImpl
import com.javierestudio.thesportsdb.framework.network.services.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class TeamModule {
    @Provides
    fun provideRepository(
        remoteDataSource: TeamsRemoteDataSource,
        localDataSource: TeamsLocalDataSource
    ): TeamsRepository =
        TeamsRepositoryImpl(remoteDataSource, localDataSource)

    @Provides
    fun provideRemote(apiService: APIService): TeamsRemoteDataSource =
        TeamsRemoteDataSourceImpl(apiService)

    @Provides
    fun provideLocal(teamDao: TeamDao): TeamsLocalDataSource =
        TeamsLocalDataSourceImpl(teamDao)

    @Provides
    fun provideApiService(retrofit: Retrofit): APIService =
        retrofit.create(APIService::class.java)

    @Provides
    fun provideDao (teamDatabase: TeamDatabase): TeamDao =
        teamDatabase.teamDao()

}