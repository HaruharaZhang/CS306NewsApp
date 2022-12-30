package com.example.finalproject_plus.connect

import android.annotation.SuppressLint
import android.util.Log
import com.google.gson.Gson
import com.kwabenaberko.newsapilib.NewsApiClient
import com.kwabenaberko.newsapilib.NewsApiClient.ArticlesResponseCallback
import com.kwabenaberko.newsapilib.models.request.EverythingRequest
import com.kwabenaberko.newsapilib.models.response.ArticleResponse
import java.net.HttpURLConnection
import java.net.URL


class NewsAPIConnector{
    private var MY_API_KEY = "50494cc6bf584519a2fd2bd555474c33"
    //private var url = "https://newsapi.org/v1/articles?source=google-news&apiKey=50494cc6bf584519a2fd2bd555474c33"
    private var url = "https://newsapi.org/v1/articles?source=google-news&apiKey=c72776346c8c4b069199f516033a799e"
    var conn: HttpURLConnection? = null

    @SuppressLint("SuspiciousIndentation")
    fun getNews(): News?{
        var receivedNews: News? = null

            //Thread {
            try {
                conn = URL(url).openConnection() as HttpURLConnection
                conn!!.setRequestProperty(
                    "User-Agent",
                    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11"
                );
                conn!!.connect()
                conn!!.inputStream.use { input ->
                    val data = input.bufferedReader().readText()
                    val gson = Gson()

                    receivedNews = gson.fromJson(data, News::class.java)
//                    if (receivedNews != null) {
//                        println(receivedNews!!.articles[0].url)
//                        println(receivedNews!!.articles[5].url)
//                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                conn?.disconnect()
            }
        //}.start()
        //Log.i("getNews", receivedNews?.articles?.get(0)?.url)
        return receivedNews
    }

    fun getNewsOld(){
        val newsApiClient = NewsApiClient(MY_API_KEY)

        newsApiClient.getEverything(
            EverythingRequest.Builder()
                .q("abc")
                .language("en")
                .build(),
            object : ArticlesResponseCallback {
                override fun onSuccess(response: ArticleResponse) {
                    Log.i("getNews", response.status)
                    Log.i("getNews", response.totalResults.toString())
                    Log.i("getNews", response.articles[0].title)
                    Log.i("getNews", response.articles[0].publishedAt)
                    Log.i("getNews", response.articles[0].description)
                    Log.i("getNews", response.articles[0].url)
                    Log.i("getNews", response.articles[0].urlToImage)
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