package com.andy.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.andy.swoosh.Utilities.EXTRA_LEAGUE
import com.andy.swoosh.R
import com.andy.swoosh.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {
    var league = ""
    var skill = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
        println(league)
    }
    fun onBallerClick(view: View) {
        skill = if (ballerSkillBtn.isChecked) "baller" else ""
        beginnerSkillBtn.isChecked = false
    }
    fun onBeginnerClick(view: View) {
        skill = if (ballerSkillBtn.isChecked) "beginner" else ""
        ballerSkillBtn.isChecked = false
    }
    fun onSkillFinishClicked(view: View) {
        if(skill != "") {
            val finishActivityIntent = Intent(this, FinishActivity::class.java)
            finishActivityIntent.putExtra(EXTRA_LEAGUE, league)
            finishActivityIntent.putExtra(EXTRA_SKILL, skill)
            startActivity(finishActivityIntent)
        }
        else {
            Toast.makeText(this, "Choose a skill level", Toast.LENGTH_SHORT).show()
        }
    }
}
