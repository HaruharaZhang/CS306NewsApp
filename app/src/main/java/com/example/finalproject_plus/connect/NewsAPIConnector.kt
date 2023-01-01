package com.example.finalproject_plus.connect

import android.annotation.SuppressLint
import android.util.Log
import com.example.finalproject_plus.New
import com.example.finalproject_plus.connect.News.Articles
import com.google.gson.Gson
import com.kwabenaberko.newsapilib.NewsApiClient
import com.kwabenaberko.newsapilib.NewsApiClient.ArticlesResponseCallback
import com.kwabenaberko.newsapilib.models.request.EverythingRequest
import com.kwabenaberko.newsapilib.models.response.ArticleResponse
import java.net.HttpURLConnection
import java.net.URL

/*
This app using Gson library to cover the Json object into Java object
Gson library can be found in here:
https://github.com/google/gson

The 'no image' picture comes from
https://www.flaticon.com/free-icon/no-pictures_5762943?term=no+photo&page=1&position=8&origin=tag&related_id=5762943
URL to this picture: https://cdn-icons-png.flaticon.com/512/5762/5762943.png
 */


class NewsAPIConnector{
    //private var MY_API_KEY = "50494cc6bf584519a2fd2bd555474c33"
    //private var MY_API_KEY = "c72776346c8c4b069199f516033a799e"
    private var MY_API_KEY = "181ee3e0b4e844c582d51db77e28908b"
    //private var url = "https://newsapi.org/v1/articles?source=google-news&apiKey=50494cc6bf584519a2fd2bd555474c33"
    //private var url = "https://newsapi.org/v1/articles?source=google-news&apiKey=c72776346c8c4b069199f516033a799e"
    private var basicUrl = "https://newsapi.org/v1/articles?source="
    var conn: HttpURLConnection? = null

    @SuppressLint("SuspiciousIndentation")
    fun getNews(source: String): News?{
        var targetUrl = basicUrl + source + "&apiKey=" + MY_API_KEY
        var receivedNews: News? = null
            //Thread {
            try {
                conn = URL(targetUrl).openConnection() as HttpURLConnection
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
    fun getNewsCustom(newsArray: List<String>): ArrayList<News> {
        //var receivedNews: News
        val receivedNewsForReturn = arrayListOf<News>()
        //var receivedNewsForReturn: ArrayList<News>?
        for (element in newsArray){
            var targetUrl = basicUrl + element + "&apiKey=" + MY_API_KEY
            try {
                conn = URL(targetUrl).openConnection() as HttpURLConnection
                conn!!.setRequestProperty(
                    "User-Agent",
                    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11"
                );
                conn!!.connect()
                conn!!.inputStream.use { input ->
                    val data = input.bufferedReader().readText()
                    val gson = Gson()
                    var receivedNews = gson.fromJson(data, News::class.java)
                    receivedNewsForReturn?.add(receivedNews)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                conn?.disconnect()
            }

            //Log.i("NewsAPI",receivedNewsForReturn.size.toString())
        }
        return receivedNewsForReturn
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