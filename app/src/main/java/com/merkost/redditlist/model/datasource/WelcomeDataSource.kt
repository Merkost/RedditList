package com.merkost.redditlist.model.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.merkost.redditlist.model.entity.Children
import com.merkost.redditlist.model.repository.RedditRepository
import kotlinx.coroutines.delay
import retrofit2.HttpException
import java.io.IOException


class WelcomeDataSource(private val repository: RedditRepository) : PagingSource<String, Children>() {

    companion object {
        var isFirstRun = true
    }

    override fun getRefreshKey(state: PagingState<String, Children>): String? {
        return null
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Children> {
        return try {
            val nextPage = params.key

            val welcomeData = repository.getHotPostsPager(after = nextPage)

            if (!isFirstRun) delay(5000) else isFirstRun = !isFirstRun

            LoadResult.Page(
                data = welcomeData.data.children,
                prevKey = if (nextPage != null) welcomeData.data.before as String? else null,
                nextKey = if (welcomeData.data.children.isEmpty()) null else welcomeData.data.after
            )

        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}
