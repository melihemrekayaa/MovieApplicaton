package com.example.movieapplicaton.data.di

import com.example.movieapplicaton.data.remote.dto.MoviesAPI
import com.example.movieapplicaton.data.repository.MovieRepositoryImpl
import com.example.movieapplicaton.domain.repository.MovieRepository
import com.example.movieapplicaton.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieApi() : MoviesAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoviesAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api : MoviesAPI) : MovieRepository {
        return MovieRepositoryImpl(api = api)
    }
}