package com.example.finalproject_plus
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

/*
The 'no image' picture comes from
https://www.flaticon.com/free-icon/no-pictures_5762943?term=no+photo&page=1&position=8&origin=tag&related_id=5762943
URL to this picture: https://cdn-icons-png.flaticon.com/512/5762/5762943.png

This code is making use of the Picasso library to pull images from News API
 */

class GamesFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val imageModelArrayList = populateList()

        val view = inflater.inflate(R.layout.fragment_games, container, false)
        val recyclerView = view?.findViewById<View>(R.id.game_recycler_view) as RecyclerView
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

        var news = NewsAPIConnector().getNews("fox-sports")
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
                    if(news.articles[i].urlToImage == null){
                        imageModel.setNewsImage("https://cdn-icons-png.flaticon.com/512/5762/5762943.png")
                    } else {
                        imageModel.setNewsImage(news.articles[i].urlToImage)
                    }
                    if(news.articles[i].publishedAt == null){
                        imageModel.setNewsTime(resources.getString(R.string.time_unknown))
                    } else {
                        imageModel.setNewsTime(news.articles[i].publishedAt.toString())
                    }

                    if(news.articles[i].author == null){
                        imageModel.setNewsAuthor(resources.getString(R.string.no_author_found))
                    } else {
                        imageModel.setNewsAuthor(news.articles[i].author)
                    }
                    if(news.articles[i].description == null){
                        imageModel.setNewsDesc(resources.getString(R.string.no_description))
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