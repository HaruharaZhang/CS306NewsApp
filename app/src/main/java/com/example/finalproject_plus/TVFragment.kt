package com.example.finalproject_plus

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject_plus.adapter.NewsAdapter
import com.example.finalproject_plus.connect.NewsAPIConnector
import com.squareup.picasso.Picasso

/*
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
        var news = NewsAPIConnector().getNews()
        val list = ArrayList<New>()
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
                    imageModel.setNewsImage(news.articles[i].urlToImage)
                    imageModel.setNewsTime(news.articles[i].publishedAt.toString())
                    //imageModel.setNewsImage()
                    //Log.i("PopularList", news.articles[i].urlToImage)
                    list.add(imageModel)
                }
            }
        }
        return list
    }
}
