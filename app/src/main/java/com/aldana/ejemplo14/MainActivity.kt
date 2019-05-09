package com.aldana.ejemplo14

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var scoreViewModel: ScoreViewModel
    var countA : Int = 0
    var countB : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)

        val scoreAObserver = Observer<Int>{ newValueA ->
            tv_score_team_a.text = newValueA.toString()
        }

        val scoreBObserver = Observer<Int> { newValueB ->
            tv_score_team_b.text = newValueB.toString()
        }

        scoreViewModel.scoreTeamA.observe(this,scoreAObserver)
        scoreViewModel.scoreTeamB.observe(this,scoreBObserver)


        // TODO: El ViewModel es restaurado si ya existía, si no, se crea uno nuevo.
        // TODO: Recuerde que el ViewModel solo sobrevive a cambios de configuración y no a la destrucción de la aplicación

        // TEAM A
        bt_team_a_3_p.setOnClickListener {
            countA +=3
            scoreViewModel.scoreTeamA.value = countA
        }

        bt_team_a_2_p.setOnClickListener {
            countA +=2
            scoreViewModel.scoreTeamA.value = countA
        }
        bt_team_a_free_throw.setOnClickListener {
            countA++
            scoreViewModel.scoreTeamA.value = countA
        }

        // TEAM B
        bt_team_b_3_p.setOnClickListener {
            countB +=3
            scoreViewModel.scoreTeamB.value = countB
        }

        bt_team_b_2_p.setOnClickListener {
            countB +=2
            scoreViewModel.scoreTeamB.value = countB
        }
        bt_team_b_free_throw.setOnClickListener {
            countB++
            scoreViewModel.scoreTeamB.value = countB
        }

        bt_reset.setOnClickListener {
            scoreViewModel.scoreTeamA.value = 0
            scoreViewModel.scoreTeamB.value = 0
        }
    }

}
