package com.example.allef.next.movilenextday3.ui.gameinfo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.allef.next.movilenextday3.R
import com.example.allef.next.movilenextday3.databinding.ActivityMainBinding
import com.example.allef.next.movilenextday3.model.Game
import com.example.allef.next.movilenextday3.utils.contentView
import kotlinx.android.synthetic.main.activity_main.*

class GameInfoActivity : AppCompatActivity() {

//    val binding:ActivityMainBinding by Lazy{
//        // variavel de binding
//        binding = DataBindingUtil.setContentView<GameInfoActivity>(this,R.layout.activity_main)
//
//    }

    val binding:ActivityMainBinding  by contentView(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val game = Game("Donkey Kong",1994,"http://www.classicgaming.cc/classics/donkey-kong/images/logo-donkey-kong.png",2.0)
        binding.game = game

        tvrating.setOnClickListener{
            game.rating = 4.5
        }
    }
}
