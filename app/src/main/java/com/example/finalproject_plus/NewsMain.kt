package com.example.finalproject_plus

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.util.TypedValue
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.finalproject_plus.SavedNews.StaticUtil.addNews
import com.example.finalproject_plus.SavedNews.StaticUtil.checkNewSaved
import com.example.finalproject_plus.SavedNews.StaticUtil.removeExistSavedNew
import com.squareup.picasso.Picasso


class NewsMain : AppCompatActivity(){
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_main)

        val backBtn = findViewById<Button>(R.id.new_main_back_btn)
        var title = findViewById<TextView>(R.id.new_main_title)
        val time = findViewById<TextView>(R.id.new_main_time)
        val desc = findViewById<TextView>(R.id.new_main_desc)
        val author = findViewById<TextView>(R.id.new_main_author)
        val image = findViewById<ImageView>(R.id.new_main_image)
        val checkNewBtn = findViewById<Button>(R.id.new_main_check_news)
        val saveBtn = findViewById<Button>(R.id.new_main_save_btn)
        val unSaveBtn = findViewById<Button>(R.id.new_main_unsave_btn)
        val fontBtn = findViewById<Button>(R.id.new_main_size_btn)

        title.text = intent.getStringExtra("title")
        author.text = intent.getStringExtra("author")
        time.text = intent.getStringExtra("time")
        desc.text = intent.getStringExtra("desc")
        Picasso.get().load(intent.getStringExtra("image")).into(image)

        backBtn.setOnClickListener() {
            finish()
        }
        checkNewBtn.setOnClickListener(){
            try {
                val internetIntent = Intent(Intent.ACTION_VIEW)
                internetIntent.addCategory(Intent.CATEGORY_BROWSABLE)
                internetIntent.setData(Uri.parse(intent.getStringExtra("url")))
                startActivity(internetIntent)
            } catch (e: Exception) {
                println("no web browser found!")
            }
        }
        saveBtn.setOnClickListener(){
            addNews(New(intent.getStringExtra("title"),
                intent.getStringExtra("desc"),
                intent.getStringExtra("image"),
                intent.getStringExtra("time"),
                intent.getStringExtra("author"),
                intent.getStringExtra("url")))
            //addNews(New())
            //Log.i("NewsMain", getSavedNews()[getSavedNews().size-1].getNewsName())
            //Log.i("NewsMain", getSavedNews().size.toString())
            saveBtn.isVisible= false
            unSaveBtn.isVisible = true
        }
        unSaveBtn.setOnClickListener(){
            removeExistSavedNew(intent.getStringExtra("title").toString())
            saveBtn.isVisible= true
            unSaveBtn.isVisible = false
        }
        if(checkNewSaved(intent.getStringExtra("title").toString())){
            //saveBtn.setVisibility(View.INVISIBLE)
            saveBtn.isVisible= false
            unSaveBtn.isVisible = true
        } else {
            saveBtn.isVisible= true
            unSaveBtn.isVisible = false
        }
        fontBtn.setOnClickListener(){
            Log.i("NewsMain", author.textSize.toString())
            Log.i("NewsMain", time.textSize.toString())
            Log.i("NewsMain", desc.textSize.toString())

            if(author.textSize.equals(33f)){
                author.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 50f)
                time.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 50f)
                desc.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40f)
            } else {
                author.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12f)
                time.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12f)
                desc.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14f)
            }
        }
    }
}