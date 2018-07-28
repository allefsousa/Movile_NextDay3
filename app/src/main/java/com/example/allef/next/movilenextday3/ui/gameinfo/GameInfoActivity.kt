package com.example.allef.next.movilenextday3.ui.gameinfo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.allef.next.movilenextday3.R
import com.example.allef.next.movilenextday3.databinding.ActivityMainBinding
import com.example.allef.next.movilenextday3.model.Game
import com.example.allef.next.movilenextday3.utils.contentView

class GameInfoActivity : AppCompatActivity() {

//    val binding:ActivityMainBinding by Lazy{
//        // variavel de binding
//        binding = DataBindingUtil.setContentView<GameInfoActivity>(this,R.layout.activity_main)
//
//    }

    val binding:ActivityMainBinding  by contentView(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val game = Game("Donkey Kong",1992,"http://www.classicgaming.cc/classics/donkey-kong/images/logo-donkey-kong.png")
        binding.game = game

    }
}
