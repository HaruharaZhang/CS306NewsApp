package com.example.finalproject_plus

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.finalproject_plus.connect.NewsAPIConnector
import com.example.finalproject_plus.verification.CustomNewsCategory
import com.example.finalproject_plus.verification.CustomNewsCategory.StaticUtil.getCategory
import com.example.finalproject_plus.verification.CustomNewsCategory.StaticUtil.setCategory


class CustomNews: AppCompatActivity(){
    lateinit var jumpIntent: Intent
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_news)
        var backBtn = findViewById<Button>(R.id.custom_back_btn)
        var saveBtn = findViewById<Button>(R.id.custom_save_btn)
        var checkBoxGeneral = findViewById<CheckBox>(R.id.custom_general)
        var checkBoxTechnology = findViewById<CheckBox>(R.id.custom_technology)
        var checkBoxSport = findViewById<CheckBox>(R.id.custom_sports)
        var checkBoxBusiness = findViewById<CheckBox>(R.id.custom_business)
        var checkBoxEntertainment = findViewById<CheckBox>(R.id.custom_entertainment)
        var checkBoxScience = findViewById<CheckBox>(R.id.custom_science)
        var checkBoxAlern = findViewById<CheckBox>(R.id.custom_alert)
        backBtn.setOnClickListener() {
            finish()
        }
        saveBtn.setOnClickListener(){
            val categoryList = mutableListOf("")
            categoryList.clear()
            if(checkBoxGeneral.isChecked) {
                categoryList.add("newsweek")//general
            }
            if(checkBoxTechnology.isChecked){
                categoryList.add("engadget") // technology
            }
            if(checkBoxSport.isChecked){
                categoryList.add("bbc-sport")//sport
            }
            if(checkBoxBusiness.isChecked){
                categoryList.add("financial-times")//business
            }
            if(checkBoxEntertainment.isChecked){
                categoryList.add("the-lad-bible")//entertainment
            }
            if(checkBoxScience.isChecked){
                categoryList.add("national-geographic")//science
            }

            setCategory(categoryList)

            if(checkBoxAlern.isChecked){
                var newsSet = NewsAPIConnector().getNewsCustom(CustomNewsCategory.StaticUtil.getCategory())
                Thread{
                    Thread.sleep(600000) //10 mins
                    var newsSetForCompare = NewsAPIConnector().getNewsCustom(CustomNewsCategory.StaticUtil.getCategory())
                    if(newsSet != newsSetForCompare){
                        val intent = Intent(this, MainActivity::class.java)
                        intent.flags =
                            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
                        val builder = NotificationCompat.Builder(this, "com.example.finalproject_plue.ONE")
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle(resources.getString(R.string.notify_title))
                            .setContentText(resources.getString(R.string.notify_desc))
                            .setPriority(NotificationCompat.PRIORITY_MAX )
                        with(NotificationManagerCompat.from(this)) {
                            notify(1, builder.build())
                    }
                }
            }
            }
            //Log.i("CustomNews", getCategory().toString())
            jumpIntent = Intent(this, MainActivity::class.java)
            startActivity(jumpIntent)
        }
    }
}
