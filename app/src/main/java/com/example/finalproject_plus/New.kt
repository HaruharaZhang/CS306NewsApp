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
    private var newsAuthor: String?= null
    private var newsUrl: String?= null
    constructor(){
    }

    constructor(news_name: String?,
                news_desc: String?,
                news_image: String?,
                news_time: String?,
                news_author: String?,
                news_url: String?){
        newsName = news_name
        newsDesc = news_desc
        newsImage = news_image
        newsTime = news_time
        newsAuthor = news_author
        newsUrl = news_url
    }

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
    fun getNewsAuthor(): String? {
        return newsAuthor
    }
    fun setNewsAuthor(newsAuthor: String){
        this.newsAuthor = newsAuthor
    }
    fun getNewsUrl(): String? {
        return newsUrl
    }
    fun setNewsUrl(newsUrl: String){
        this.newsUrl = newsUrl
    }

}