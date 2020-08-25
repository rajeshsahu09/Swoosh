package com.example.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.utilities.EXTRA_LEAGUE
import com.example.swoosh.R
import com.example.swoosh.utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_league.*
import kotlinx.android.synthetic.main.activity_skillselection.*

class SkillselectionActivity : BaseActivity() {
    var selectedSkill = ""
    var league = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skillselection)
        league = intent.getStringExtra(EXTRA_LEAGUE).toString()
    }

    fun onBeginnerClick(view: View) {
        ballerbtn.isChecked = false
        selectedSkill = "Beginner"
    }

    fun onBallerClick(view: View) {
        beginnerbtn.isChecked = false
        selectedSkill = "Baller"
    }

    fun onFinishClick(view: View) {
        if(!beginnerbtn.isChecked && !ballerbtn.isChecked)
            selectedSkill = ""
        if(selectedSkill != "") {
            val finishIntent = Intent(this, FinishActivity::class.java)
            finishIntent.putExtra(EXTRA_LEAGUE, league)
            finishIntent.putExtra(EXTRA_SKILL, selectedSkill)
            startActivity(finishIntent)
        } else {
            Toast.makeText(this, "Select Skill Level \uD83D\uDE14", Toast.LENGTH_SHORT).show()
        }
    }
}