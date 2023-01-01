package com.example.finalproject_plus

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject_plus.adapter.NewsAdapter
import com.example.finalproject_plus.connect.NewsAPIConnector
import com.squareup.picasso.Picasso

/*
The 'no image' picture comes from
https://www.flaticon.com/free-icon/no-pictures_5762943?term=no+photo&page=1&position=8&origin=tag&related_id=5762943
URL to this picture: https://cdn-icons-png.flaticon.com/512/5762/5762943.png

This code is making use of the Picasson library to pull images from News API
 */


class TVFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val imageModelArrayList = populateList()


        val view = inflater.inflate(R.layout.fragment_tv, container, false)
        val recyclerView = view?.findViewById<View>(R.id.tv_recycler_view) as RecyclerView
        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        val mAdapter = NewsAdapter(imageModelArrayList)
        recyclerView.adapter = mAdapter

        return view
    }
    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)

    }

    private fun populateList(): ArrayList<New> {
        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        var news = NewsAPIConnector().getNews("breitbart-news")
        val list = ArrayList<New>()
        if (news != null) {
            if(news.articles.size != 0){

                for (i in 0 until news.articles.size) {
                    val imageModel = New()

                    if(news.articles[i].title.length > 135){
                        imageModel.setNewsName(news.articles[i].title.substring(0,130) + ".....")
                    } else {
                        imageModel.setNewsName(news.articles[i].title)
                    }
                    if(news.articles[i].urlToImage == null){
                        imageModel.setNewsImage("https://cdn-icons-png.flaticon.com/512/5762/5762943.png")
                    } else {
                        imageModel.setNewsImage(news.articles[i].urlToImage)
                    }
                    if(news.articles[i].publishedAt == null){
                        imageModel.setNewsTime("time unknown")
                    } else {
                        imageModel.setNewsTime(news.articles[i].publishedAt.toString())
                    }

                    if(news.articles[i].author == null){
                        imageModel.setNewsAuthor("no author found")
                    } else {
                        imageModel.setNewsAuthor(news.articles[i].author)
                    }
                    if(news.articles[i].description == null){
                        imageModel.setNewsDesc("no description for this articles")
                    } else {
                        imageModel.setNewsDesc(news.articles[i].description)
                    }
                    imageModel.setNewsUrl(news.articles[i].url)
                    list.add(imageModel)
                }
            }
        }
        return list
    }
}
