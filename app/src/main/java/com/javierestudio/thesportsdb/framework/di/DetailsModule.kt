package com.javierestudio.thesportsdb.framework.di

import com.javierestudio.thesportsdb.core.data.matches.MatchesRemoteDataSource
import com.javierestudio.thesportsdb.core.data.matches.MatchesRepositoryImpl
import com.javierestudio.thesportsdb.core.domain.matches.repository.MatchesRepository
import com.javierestudio.thesportsdb.framework.network.datasource.MatchesRemoteDataSourceImpl
import com.javierestudio.thesportsdb.framework.network.services.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DetailsModule {
    @Provides
    fun provideRepository(matchesRemoteDataSource: MatchesRemoteDataSource): MatchesRepository =
        MatchesRepositoryImpl(matchesRemoteDataSource)

    @Provides
    fun provideRemote(apiService: APIService): MatchesRemoteDataSource =
        MatchesRemoteDataSourceImpl(apiService)
}