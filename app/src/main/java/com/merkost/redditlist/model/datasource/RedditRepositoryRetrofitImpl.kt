package com.merkost.redditlist.model.datasource

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.merkost.redditlist.model.api.RedditDatabaseApiService
import com.merkost.redditlist.model.entity.ChildData
import com.merkost.redditlist.model.entity.Children
import com.merkost.redditlist.model.entity.Welcome1
import com.merkost.redditlist.model.entity.Welcome1Data
import com.merkost.redditlist.model.repository.RedditRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RedditRepositoryRetrofitImpl : RedditRepository {
    companion object {
        private const val BASE_REDDIT_URL = "https://www.reddit.com/"
    }

    override suspend fun getHotPosts(): Flow<List<Children>> = flow {
        val redditResult = getService().getHotPosts()
        emit(redditResult.data.children)
    }

    override suspend fun getHotPostsPager(after: String?): Welcome1 {
        return getService().getHotPostsPager(after)
    }

    private fun getService(): RedditDatabaseApiService {
        return createRetrofit().create(RedditDatabaseApiService::class.java)
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_REDDIT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(createOkHttpClient())
            .build()
    }

    private fun createOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(getLoggingIntercepter()).build()

    private fun getLoggingIntercepter() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)

}