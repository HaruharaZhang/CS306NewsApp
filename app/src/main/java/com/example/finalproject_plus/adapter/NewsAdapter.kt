package com.example.finalproject_plus.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject_plus.New
import com.example.finalproject_plus.NewsMain
import com.example.finalproject_plus.R
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

/*
This class is using Picasso to load the image into the app
info: https://square.github.io/picasso/
 */

class NewsAdapter (private val imageModelArrayList: MutableList<New>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    /*
     * Inflate our views using the layout defined in row_layout.xml
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.news_row_layout, parent, false)
        return ViewHolder(v)
    }

    /*
     * Bind the data to the child views of the ViewHolder
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val info = imageModelArrayList[position]
        //Log.i("NewsAdapter", imageModelArrayList[position].getNewsName())
        //if(imageModelArrayList[position].getNewsName().equals(null)){
            Picasso.get().load(info.getNewsImage()).fit().into(holder.newsImage)
            holder.newsTitle.text = info.getNewsName()
            holder.newsDesc.text = info.getNewsTime()
        //}
    }

    /*
     * Get the maximum size of the
     */
    override fun getItemCount(): Int {
        return imageModelArrayList.size
    }


    /*
     * The parent class that handles layout inflation and child view use
     */
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{

        var newsImage = itemView.findViewById<View>(R.id.icon) as ImageView
        var newsTitle = itemView.findViewById<View>(R.id.new_main_title) as TextView
        var newsDesc = itemView.findViewById<View>(R.id.new_desc) as TextView


        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            var index = 0
            for (i in 0 until imageModelArrayList.size) {
                if(imageModelArrayList[i].getNewsName() == newsTitle.text){
                    index = i
                    break
                }
            }
            var intent = Intent(itemView.context, NewsMain::class.java)
            intent.putExtra("title", imageModelArrayList[index].getNewsName())
            intent.putExtra("author", imageModelArrayList[index].getNewsAuthor())
            intent.putExtra("time", imageModelArrayList[index].getNewsTime())
            intent.putExtra("desc", imageModelArrayList[index].getNewsDesc())
            intent.putExtra("image",imageModelArrayList[index].getNewsImage())
            intent.putExtra("url", imageModelArrayList[index].getNewsUrl())

            itemView.context.startActivity(intent)

        }
    }
}