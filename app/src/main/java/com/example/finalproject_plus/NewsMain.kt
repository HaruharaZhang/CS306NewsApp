package com.example.finalproject_plus

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
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
                internetIntent.addCategory(Intent.CATEGORY_BROWSABLE);
                internetIntent.setData(Uri.parse(intent.getStringExtra("url")))
                startActivity(internetIntent)
            } catch (e: Exception) {
                println("no web browser found!")
            }
        }


    }
}