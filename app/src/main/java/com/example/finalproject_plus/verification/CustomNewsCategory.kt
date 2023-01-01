package com.example.finalproject_plus.verification


class CustomNewsCategory {
    //static objects and methods
    object StaticUtil {
        private var category = emptyList<String>()
        fun setCategory(array: List<String>) {
            category = array
        }

        fun getCategory(): List<String> {
            return category
        }

        fun cleanCategory() {
            category = emptyList()
        }
    }
}