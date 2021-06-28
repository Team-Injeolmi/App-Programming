package com.example.appproject01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.appproject01.retrofit.API
import com.example.appproject01.retrofit.DTO
import com.example.appproject01.retrofit.clinet
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.w3c.dom.Text
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var retService: API

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        retService = clinet().getService().create(API::class.java)

        val res: LiveData<Response<DTO>> = liveData {
            val response = retService.JSON()
            emit(response)
        }

        res.observe(this, androidx.lifecycle.Observer {
            val temp = findViewById<TextView>(R.id.temp)
            temp.text = it.body()?.temp
            val temp_text = findViewById<TextView>(R.id.temp_text)
            temp_text.text = it.body()?.station + " 기준"
            val random_text = findViewById<TextView>(R.id.random_text)
            random_text.text = it.body()?.time + " 에 측정한 온도입니다."
        })

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
