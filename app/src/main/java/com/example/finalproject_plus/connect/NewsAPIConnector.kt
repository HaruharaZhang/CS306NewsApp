package com.example.finalproject_plus.connect

import android.util.Log
import com.kwabenaberko.newsapilib.NewsApiClient
import com.kwabenaberko.newsapilib.NewsApiClient.ArticlesResponseCallback
import com.kwabenaberko.newsapilib.models.request.EverythingRequest
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest
import com.kwabenaberko.newsapilib.models.response.ArticleResponse


class NewsAPIConnector {
    private var MY_API_KEY = "50494cc6bf584519a2fd2bd555474c33"

    fun getNews(){
        Log.i("getNews", "inside the function!")
        val newsApiClient = NewsApiClient(MY_API_KEY)
        newsApiClient.getEverything(
            EverythingRequest.Builder()
                .q("trump")
                .language("en")
                .build(),
            object : ArticlesResponseCallback {
                override fun onSuccess(response: ArticleResponse) {
                    Log.i("getNews", response.status)
                    Log.i("getNews", response.totalResults.toString())
                    Log.i("getNews", response.articles[0].title)
                    Log.i("getNews", response.articles[0].publishedAt)
                    //Log.i("getNews", response.articles[0].description)
                    Log.i("getNews", response.articles[0].url)
                    //Log.i("getNews", response.articles[0].urlToImage)
                }

                override fun onFailure(throwable: Throwable) {
                    println(throwable.message)
                    Log.i("getNews", "an error occurred!")
                    Log.i("getNews", throwable.message.toString())
                }
            }
        )
    }
}