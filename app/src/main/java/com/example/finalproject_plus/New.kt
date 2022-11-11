package com.example.finalproject_plus

/*
 * Data model class to store logos and team names from F1
 */
class New {
    private var newsId: Int? = null
    private var newsName: String? = null
    private var newsDesc: String? = null
    private var newsImage: Int = 0

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
    fun getNewsImage(): Int{
        return newsImage
    }
    fun setNewsImage(new_image: Int){
        this.newsImage = new_image
    }

}