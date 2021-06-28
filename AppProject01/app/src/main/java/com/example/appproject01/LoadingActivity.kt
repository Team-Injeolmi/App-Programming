package com.example.appproject01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import java.util.*

class LoadingActivity : AppCompatActivity() {

    val proverb: List<String> = listOf(
        "꿈꿀 수 있다면 실현할 수 있다.",
        "고통은 잠깐이다. 포기는 영원히 남는다.",
        "삶이 있는 한 희망은 있다.",
        "피할 수 있으면 즐겨라.",
        "한 번의 실패와 영원한 실패를 혼동하지 마라.",
        "자신감있는 표정을 지으면 자신감이 생긴다.",
        "세상은 고통으로 가득하지만 그것을 극복하는 사람들로도 가득하다.",
        "인생을 다시 산다면 다음번에는 더 많은 실수를 저지르리라",
        "나 자신을 받아들이면 내가 남들과 다름을 설득하려고 애쓸 필요가 없다.",
        "당신의 상처가 아닌, 당신의 희망이 당신의 미래를 만들게 하라."
    )
    val people_name: List<String> = listOf(
        "윌트 디즈니",
        "랜스 암스트롱",
        "마르쿠스 툴리우스 키케로",
        "로버트 엘리엇",
        "F.스콧 핏제랄드",
        "찰스 다윈",
        "헬렌 켈러",
        "나딘 스테어",
        "버니 스웨인 \'터닝 포인트\'",
        "로버트 H. 슐러"
    )

    val random = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        randText()

        val handler = Handler()
        handler.postDelayed({
            val intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

    fun randText() {
        val randIndex = random.nextInt(proverb.size - 1)

        val proverbTextView = findViewById<TextView>(R.id.proverb)
        proverbTextView.text = proverb.get(randIndex)

        val nameTextView = findViewById<TextView>(R.id.name)
        nameTextView.text = "- " + people_name.get(randIndex)
    }
}