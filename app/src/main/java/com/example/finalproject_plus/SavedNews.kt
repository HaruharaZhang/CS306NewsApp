package com.example.finalproject_plus

class SavedNews {
    object StaticUtil {
        private var savedNews = ArrayList<New>()
                fun getSavedNews(): ArrayList<New> {
                    return savedNews
                }
        fun setSavedNews(saved_news: ArrayList<New>){
            savedNews = saved_news
        }
        fun addNews(new: New){
            savedNews.add(new)
        }
        fun removeExistSavedNew(newsName: String): Boolean {
            for(element in savedNews){
                if(element.getNewsName() == newsName){
                    savedNews.remove(element)
                    return true
                }
            }
            return false
        }
        fun checkNewSaved(newsName: String): Boolean {
            for(element in savedNews){
                if(element.getNewsName() == newsName){
                    return true
                }
            }
            return false
        }
    }
}