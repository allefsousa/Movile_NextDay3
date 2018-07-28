package com.example.allef.next.movilenextday3.ui.gameinfo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.allef.next.movilenextday3.R
import com.example.allef.next.movilenextday3.databinding.ActivityMainBinding
import com.example.allef.next.movilenextday3.gameadd.GameAddActivity
import com.example.allef.next.movilenextday3.model.Game
import com.example.allef.next.movilenextday3.utils.contentView
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
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
        //testesRxJava()
        fabAdd.setOnClickListener{
            val intent = Intent(this,GameAddActivity::class.java)
            startActivity(intent)
        }
    }

    fun testesRxJava(){
//        val observable = Observable.just(1,2,3)// MainThered
        val tag = "RxJava"
//        val Observer = object :Observer<Int>{
//            override fun onComplete() {
//                Log.i(tag,"OnComplete ")
//            }
//
//            override fun onSubscribe(d: Disposable) {
//                Log.i(tag,"Subscribe $d")
//            }
//
//            override fun onNext(t: Int) {
//                Log.i(tag,"Next $t")
//            }
//
//            override fun onError(e: Throwable) {
//                Log.i(tag,"Error",e)
//            }
//
//        }
//        observable.subscribe(Observer)
        //declaração simplificada do metodo onNext
//        observable.subscribe({Log.i(tag,"OnNext diferente $it")})

        Observable.just(1,2,3)
                .map { it*2 } // multiplicando elementos da lista
                .filter { it<6 } // filtrando elementos menores que 6
                .subscribe({Log.i(tag,"OnNext diferente $it")})


    }

}
