package com.example.finalproject_plus.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.finalproject_plus.*

class TabAdapter (activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(index: Int): Fragment {
        when (index) {
            0 -> return TVFragment()
            1 -> return GamesFragment()
            2 -> return MoviesFragment()
            3 -> return CustomFragment()
        }
        return TVFragment()
    }

    // get item count - equal to number of tabs
    override fun getItemCount(): Int
    {
        return 4
    }
}