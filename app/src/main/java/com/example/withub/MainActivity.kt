package com.example.withub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import com.bumptech.glide.Glide
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.yy.mobile.rollingtextview.CharOrder
import com.yy.mobile.rollingtextview.RollingTextView
import com.yy.mobile.rollingtextview.strategy.Strategy


class MainActivity : AppCompatActivity() {
    
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView : NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        //dasdasdasdas

        //toolbar 설정
        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowCustomEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_nav)
        supportActionBar!!.setDisplayShowTitleEnabled(false) // 기본 타이틀 미사용

        drawerLayout = findViewById<DrawerLayout>(R.id.main_drawer_layout)
        navigationView = findViewById<NavigationView>(R.id.navigation_view)


        // 네비게이션 설정
        var headerView = navigationView.getHeaderView(0)
        headerView.setBackgroundColor(resources.getColor(R.color.point_color,null))
        var navHeaderImageView = headerView.findViewById<ImageView>(R.id.nav_header_img)
        var rollingTextView = findViewById<RollingTextView>(R.id.toolbar_ticker_view)
        rollingTextView.animationDuration = 2000L
        rollingTextView.charStrategy = Strategy.NormalAnimation()
        rollingTextView.addCharOrder(CharOrder.Number)
        rollingTextView.animationInterpolator = AccelerateDecelerateInterpolator()
        rollingTextView.setText("5")

        Glide.with(this)
            .load("https://avatars.githubusercontent.com/u/84075111?v=4")
            .placeholder(R.mipmap.nav_header_loading_img) // 로딩 이미지
            .error(R.mipmap.nav_header_loading_img)//로딩 실패 이미지
            .circleCrop()//원형으로 깎기
            .into(navHeaderImageView)
    }
    
    //홈에서 네비게이션 열기
    @Override
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home ->{drawerLayout.openDrawer(GravityCompat.START)
            }
        }
        return super.onOptionsItemSelected(item)
    }
    
    // 뒤로가기 눌렀을 때 네비게이션 닫기
    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else {
            super.onBackPressed()
        }
        }

}