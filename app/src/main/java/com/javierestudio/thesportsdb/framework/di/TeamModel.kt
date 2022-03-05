package com.javierestudio.thesportsdb.framework.di

import com.javierestudio.core.data.TeamsRemoteDataSource
import com.javierestudio.core.data.TeamsRepositoryImpl
import com.javierestudio.core.domain.league.repository.TeamsRepository
import com.javierestudio.thesportsdb.framework.network.datasource.TeamsRemoteDataSourceImpl
import com.javierestudio.thesportsdb.framework.network.services.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class TeamModel {
    @Provides
    fun provideRepository(remoteDataSource: TeamsRemoteDataSource): TeamsRepository =
        TeamsRepositoryImpl(remoteDataSource)

    @Provides
    fun provideRemote(apiService: APIService): TeamsRemoteDataSource =
        TeamsRemoteDataSourceImpl(apiService)

    @Provides
    fun provideApiService(retrofit: Retrofit): APIService =
        retrofit.create(APIService::class.java)

}