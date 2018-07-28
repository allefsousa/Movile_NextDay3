package com.example.allef.next.movilenextday3

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.allef.next.movilenextday3.databinding.ActivityMainBinding

class GameInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // variavel de binding
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val game = Game("Donkey Kong")
        binding.game = game

    }
}
