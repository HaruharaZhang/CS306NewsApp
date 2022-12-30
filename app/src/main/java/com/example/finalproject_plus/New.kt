package com.example.finalproject_plus

import com.squareup.picasso.RequestCreator
import java.util.Date

/*
 * Data model class to store logos and team names from F1
 */
class New {
    private var newsId: Int? = null
    private var newsName: String? = null
    private var newsDesc: String? = null
    private var newsImage: String?= null
    private var newsTime: String? = null

    fun getNewsId(): Int? {
        return newsId
    }
    fun setNewsId(new_id: Int){
        this.newsId = new_id
    }
    fun getNewsName(): String{
        return newsName.toString()
    }
    fun setNewsName(new_name: String){
        this.newsName = new_name
    }
    fun getNewsDesc(): String{
        return newsDesc.toString()
    }
    fun setNewsDesc(new_desc: String){
        this.newsDesc = new_desc
    }
    fun getNewsImage(): String? {
        return newsImage
    }
    fun setNewsImage(new_image: String){
        this.newsImage = new_image
    }
    fun getNewsTime(): String? {
        return newsTime
    }
    fun setNewsTime(newsTime: String){
        this.newsTime = newsTime
    }

}