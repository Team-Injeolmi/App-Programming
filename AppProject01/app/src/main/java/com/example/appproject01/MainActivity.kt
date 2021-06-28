package com.example.appproject01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.widget.Toolbar
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.appproject01.HomeActivity as HomeActivity1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()
        // 초기 fragment 셋팅
        supportFragmentManager.beginTransaction().replace(R.id.frameManager, HomeFragment()).commit()
        // navigationBottomView 등록
        transitonNavigationBottomView(findViewById(R.id.bottom_nav), supportFragmentManager)
    }

    fun transitonNavigationBottomView(bottomView: BottomNavigationView, fragmentManager: FragmentManager){
        bottomView.setOnNavigationItemSelectedListener {
            it.isChecked = true
            when(it.itemId){
                R.id.home_menu -> {
                    fragmentManager.beginTransaction().replace(R.id.frameManager, HomeFragment()).commit()
                }
                R.id.about_menu -> {
                    fragmentManager.beginTransaction().replace(R.id.frameManager, AboutFragment()).commit()
                }
                else -> Log.d("test", "error") == 0
            }
            Log.d("test", "final") == 0
        }
    }
}
