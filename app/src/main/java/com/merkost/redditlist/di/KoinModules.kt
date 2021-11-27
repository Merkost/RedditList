package com.merkost.redditlist.di

import com.merkost.redditlist.model.datasource.RedditRepositoryRetrofitImpl
import com.merkost.redditlist.model.repository.RedditRepository
import com.merkost.redditlist.viewmodels.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val application = module {
    single<RedditRepository> { RedditRepositoryRetrofitImpl() }
}

val mainActivity = module {
    viewModel { MainViewModel(get()) }
    //viewModel { MovieDetailsViewModel(get()) }
}