package com.example.finalproject_plus.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject_plus.MainActivity
import com.example.finalproject_plus.New
import com.example.finalproject_plus.NewsMain
import com.example.finalproject_plus.R
import com.example.finalproject_plus.connect.NewsAPIConnector
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

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

        Picasso.get().load(info.getNewsImage()).into(holder.newsImage)
        holder.newsTitle.text = info.getNewsName()

        holder.newsDesc.text = info.getNewsTime()


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
        var newsTitle = itemView.findViewById<View>(R.id.new_title) as TextView
        var newsDesc = itemView.findViewById<View>(R.id.new_desc) as TextView

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val msg = newsTitle.text
            //NewsAPIConnector().getNews()
            //NewsAPIConnector().getNews()
            val snackbar = Snackbar.make(v, "$msg", Snackbar.LENGTH_LONG)
            snackbar.show()
        }
    }
}




//var intent = Intent(itemView.context, TeamDetail::class.java)
//itemView.context.startActivity(intent)