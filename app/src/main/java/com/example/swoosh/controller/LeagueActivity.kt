package com.example.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.R
import com.example.swoosh.model.Player
import com.example.swoosh.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {
    var player: Player = Player("", "")

    /**
     * when we change an activity from potrait to landscape or vice versa
     * The current activity is destroyed.
     * So we need to store the current activities values to pass onto other.
     * onSaveInstanceState(outState: Bundle) --> save state in this fun
     *  onRestoreInstanceState(savedInstanceState: Bundle) or "onCreate(savedInstanceState: Bundle?)"--> restore the values on this state
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null) player = savedInstanceState.getParcelable(EXTRA_PLAYER)!!
    }

    fun onMensClicked(view: View) {
        womensbtn.isChecked = false
        coedbtn.isChecked = false
        player.league = "Men's"
    }
    fun onWomensClicked(view: View) {
        mensbtn.isChecked = false
        coedbtn.isChecked = false
        player.league = "Women's"
    }
    fun onCoedClicked(view: View) {
        mensbtn.isChecked = false
        womensbtn.isChecked = false
        player.league = "Co-Ed"
    }
    fun onNextBtnClick(view: View) { // another way of onclick action for buttons :: cool
        if(!mensbtn.isChecked && !womensbtn.isChecked && !coedbtn.isChecked)
            player.league = ""
        if(player.league != "") {
            val skillIntent = Intent(this, SkillselectionActivity::class.java)
            skillIntent.putExtra(EXTRA_PLAYER, player)
            startActivity(skillIntent)
        } else {
            Toast.makeText(this, "Select League Type \uD83D\uDE14", Toast.LENGTH_SHORT).show()
        }
    }
}
