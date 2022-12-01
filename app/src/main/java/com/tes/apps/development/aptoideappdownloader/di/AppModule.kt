package com.tes.apps.development.aptoideappdownloader.di

import com.tes.apps.development.aptoideappdownloader.data.remote.AptoideApi
import com.tes.apps.development.aptoideappdownloader.data.repository.AptoideRepositoryImpl
import com.tes.apps.development.aptoideappdownloader.domain.repository.AptoideRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)

class AppModule {
    private val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })
        .build()

    @Provides
    fun providesRetrofit(): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(AptoideApi.BASE_URL)
        .build()

    @Provides
    fun providesShowsApi(retrofit: Retrofit): AptoideApi = retrofit.create(AptoideApi::class.java)

    @Provides
    fun providesRepository(
        aptoideApi: AptoideApi,
    ): AptoideRepository {
        return AptoideRepositoryImpl(aptoideApi)
    }

}