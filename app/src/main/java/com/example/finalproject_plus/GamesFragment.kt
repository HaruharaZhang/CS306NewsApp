package com.example.finalproject_plus
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject_plus.adapter.NewsAdapter

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
        val list = ArrayList<New>()
        val newsList = arrayOf(R.drawable.shark1, R.drawable.shark2, R.drawable.shark3, R.drawable.shark4, R.drawable.shark5, R.drawable.shark6, R.drawable.shark7, R.drawable.shark8, R.drawable.shark9, R.drawable.shark1)
        val newsTitleList = arrayOf(R.string.shark1, R.string.shark2, R.string.shark3, R.string.shark4, R.string.shark5, R.string.shark6, R.string.shark7, R.string.shark8, R.string.shark9)

        val newsDesc = R.string.newsDesc
        for (i in 0..8) {
            val imageModel = New()
            imageModel.setNewsName(getString(newsTitleList[i]))
            //imageModel.setNewsImage(newsList[i])
            //imageModel.setNewsDesc(getString(newsDesc))
            list.add(imageModel)
        }
        return list
    }


}