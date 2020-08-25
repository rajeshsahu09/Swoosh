package com.example.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.utilities.EXTRA_LEAGUE
import com.example.swoosh.R
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {
    var selectedLeague = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

//        nextbtn.setOnClickListener {
//            val skillIntent = Intent(this, SkillselectionActivity::class.java)
//            startActivity(skillIntent)
//        }
    }
    fun onMensClicked(view: View) {
        womensbtn.isChecked = false
        coedbtn.isChecked = false
        selectedLeague = "Men's"
    }
    fun onWomensClicked(view: View) {
        mensbtn.isChecked = false
        coedbtn.isChecked = false
        selectedLeague = "Women's"
    }
    fun onCoedClicked(view: View) {
        mensbtn.isChecked = false
        womensbtn.isChecked = false
        selectedLeague = "Co-Ed"
    }
    fun onNextBtnClick(view: View) { // another way of onclick action for buttons :: cool
        if(!mensbtn.isChecked && !womensbtn.isChecked && !coedbtn.isChecked)
            selectedLeague = ""
        if(selectedLeague != "") {
            val skillIntent = Intent(this, SkillselectionActivity::class.java)
            skillIntent.putExtra(EXTRA_LEAGUE, selectedLeague)
            startActivity(skillIntent)
        } else {
            Toast.makeText(this, "Select League Type \uD83D\uDE14", Toast.LENGTH_SHORT).show()
        }
    }
}
