package com.example.finalproject_plus

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.StrictMode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject_plus.adapter.NewsAdapter
import com.example.finalproject_plus.connect.NewsAPIConnector
import com.example.finalproject_plus.verification.CustomNewsCategory

class CustomFragment: Fragment(){
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val imageModelArrayList = populateList()

        val view = inflater.inflate(R.layout.fragment_movies, container, false)
        val recyclerView = view?.findViewById<View>(R.id.movie_recycler_view) as RecyclerView
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
        //val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        //StrictMode.setThreadPolicy(policy)

        //var news = NewsAPIConnector().getNews("mtv-news")
        var newsSet = NewsAPIConnector().getNewsCustom(CustomNewsCategory.StaticUtil.getCategory())
        val list = ArrayList<New>()
        for(elemets in newsSet){
            val news = elemets
            if (news != null) {
                if(news.articles.size != 0){
//                print(news.status)
//                print(news.articles[0].url)
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

        }
        return list
    }
}