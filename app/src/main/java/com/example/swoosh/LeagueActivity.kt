package com.example.swoosh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_league.*
import kotlinx.android.synthetic.main.activity_main.*

class LeagueActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

//        nextbtn.setOnClickListener {
//            val skillIntent = Intent(this, SkillselectionActivity::class.java)
//            startActivity(skillIntent)
//        }
    }
    fun onNextBtnClick(view: View) { // another way of onclick action for buttons :: cool
        val skillIntent = Intent(this, SkillselectionActivity::class.java)
        startActivity(skillIntent)
    }
}