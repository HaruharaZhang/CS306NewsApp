package com.example.finalproject_plus

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject_plus.SavedNews.StaticUtil.getSavedNews
import com.example.finalproject_plus.adapter.NewsAdapter


class SaveNews: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val imageModelArrayList = getSavedNews()
        val view = inflater.inflate(R.layout.save_news, container, false)
        val recyclerView = view?.findViewById<View>(R.id.save_news_recycler_view) as RecyclerView
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

    override fun onStart() {
        super.onStart()
        val imageModelArrayList = getSavedNews()
        //val view = inflater.inflate(R.layout.save_news, container, false)
        val recyclerView = view?.findViewById<View>(R.id.save_news_recycler_view) as RecyclerView
        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        val mAdapter = NewsAdapter(imageModelArrayList)
        recyclerView.adapter = mAdapter
    }
}