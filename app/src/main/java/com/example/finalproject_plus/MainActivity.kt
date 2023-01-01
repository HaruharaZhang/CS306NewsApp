package com.example.finalproject_plus

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager2.widget.ViewPager2
import com.example.finalproject_plus.adapter.TabAdapter
import com.example.finalproject_plus.verification.Authorization
import com.example.finalproject_plus.verification.Login
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.FirebaseApp


class MainActivity : AppCompatActivity() {

    lateinit var jumpIntent: Intent
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        jumpIntent = Intent(this, Login::class.java)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        //val savedNews = findViewById<Item>(R.id.savedNews)
        val myTitle = R.string.title
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setTitle(myTitle).toString()

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = findViewById<ViewPager2>(R.id.pager)

        val tabTitles = resources.getStringArray(R.array.tabTitles)
        viewPager.adapter = TabAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = tabTitles[0]
                1 -> tab.text = tabTitles[1]
                2 -> tab.text = tabTitles[2]
                3 -> tab.text = tabTitles[3]
                4 -> tab.text = tabTitles[4]
            }
        }.attach()

        FirebaseApp.initializeApp(this);

        var drawerListener = CustomDrawer()
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        drawerLayout.addDrawerListener(drawerListener)

    }

    @SuppressLint("ResourceType")
    override fun onStart() {
        super.onStart()
        if(Authorization().getUserStatus()){
            Authorization().getUser()
        } else {
            val navHeader = findViewById<NavigationView>(R.id.navView)
            val topHeader = navHeader.getHeaderView(0)
            navHeader.removeHeaderView(topHeader) //remove top header
            navHeader.inflateHeaderView(R.layout.nav_header_login)
        }

        //var toolbar = findViewById<Toolbar>(R.id.toolbar)
        val navHeader = findViewById<NavigationView>(R.id.navView)

        navHeader.menu.findItem(R.id.nav_refresh).setOnMenuItemClickListener {
            Toast.makeText(this, R.string.refresh_news, Toast.LENGTH_LONG).show()
            finish();
            startActivity(getIntent())
            //Toast.makeText(this, "Done! news refreshed", Toast.LENGTH_LONG).show()
            true
        }
        navHeader.menu.findItem(R.id.nav_custom_news).setOnMenuItemClickListener {
            jumpIntent = Intent(this, CustomNews::class.java)
            startActivity(jumpIntent)
            true
        }

//        navHeader.menu.findItem(R.id.savedNews).setOnMenuItemClickListener {
//            jumpIntent = Intent(this, SavedNews::class.java)
//            startActivity(jumpIntent)
//            true
//        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate((R.menu.toolbar_layout), menu)
        return super.onCreateOptionsMenu(menu)
    }
    fun jump(view: View){
        val intent = Intent()
        intent.setClass(this,view::class.java)
        startActivity(intent)
    }
    private val startForLogin =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data
//                val resultView = findViewById<TextView>(R.id.results)
//                if (intent != null) {
//                    resultView.text = intent.extras?.getString("return")
//                } else {
//                    resultView.text = getString(R.string.empty)
//                }
            }
        }
    inner class CustomDrawer : DrawerLayout.DrawerListener{

        override fun onDrawerStateChanged(newState: Int) {
        }

        override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
            //imm.hideSoftInputFromWindow(drawerView?.getWindowToken(), 0)
        }

        override fun onDrawerClosed(drawerView: View) {
            //imm.hideSoftInputFromWindow(drawerView?.getWindowToken(), 0)
        }

        override fun onDrawerOpened(drawerView: View) {
            val navHeader = findViewById<NavigationView>(R.id.navView)
            //if user still not login yet, show the big blue button
            if(!Authorization().getUserStatus()){

                val loginBtn = navHeader.findViewById<Button>(R.id.login_btn)

                loginBtn.setOnClickListener{
                    jumpIntent.putExtra("name", "MainActivity")
                    startForLogin.launch(jumpIntent)
                }
            } else {
                val userEmail = navHeader.findViewById<TextView>(R.id.nav_email)
                userEmail.text = Authorization().getUserEmail()

                //this is logout button
                //val navHeader = findViewById<NavigationView>(R.id.navView)
                val logoutBtn = navHeader.findViewById<Button>(R.id.custom_save_btn)
                logoutBtn.setOnClickListener {
                    Authorization().logout()
                    finish()
                }
            }
        }
    }
}