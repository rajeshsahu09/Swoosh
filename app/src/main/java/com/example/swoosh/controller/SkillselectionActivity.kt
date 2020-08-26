package com.example.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.R
import com.example.swoosh.model.Player
import com.example.swoosh.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*
import kotlinx.android.synthetic.main.activity_skillselection.*

class SkillselectionActivity : BaseActivity() {
    lateinit var player: Player // if initialise later, right now just declare

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
        setContentView(R.layout.activity_skillselection)
        player = intent.getParcelableExtra(EXTRA_PLAYER)!!
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null) player = savedInstanceState.getParcelable(EXTRA_PLAYER)!!
    }

    fun onBeginnerClick(view: View) {
        ballerbtn.isChecked = false
        player.skill = "Beginner"
    }

    fun onBallerClick(view: View) {
        beginnerbtn.isChecked = false
        player.skill = "Baller"
    }

    fun onFinishClick(view: View) {
        if(!beginnerbtn.isChecked && !ballerbtn.isChecked)
            player.skill = ""
        if(player.skill != "") {
            val finishIntent = Intent(this, FinishActivity::class.java)
            finishIntent.putExtra(EXTRA_PLAYER, player)
            startActivity(finishIntent)
        } else {
            Toast.makeText(this, "Select Skill Level \uD83D\uDE14", Toast.LENGTH_SHORT).show()
        }
    }
}