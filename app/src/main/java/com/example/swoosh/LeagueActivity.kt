package com.example.swoosh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*
import kotlinx.android.synthetic.main.activity_main.*

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
        selectedLeague = "men"
    }
    fun onWomensClicked(view: View) {
        mensbtn.isChecked = false
        coedbtn.isChecked = false
        selectedLeague = "women"
    }
    fun onCoedClicked(view: View) {
        mensbtn.isChecked = false
        womensbtn.isChecked = false
        selectedLeague = "coed"
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
            selectedLeague = ""
        }
    }
}
