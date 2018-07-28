package com.example.allef.next.movilenextday3.gameadd

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.example.allef.next.movilenextday3.R
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.Flowables
import kotlinx.android.synthetic.main.activity_game_add.*
import java.util.concurrent.TimeUnit

class GameAddActivity : AppCompatActivity() {
    lateinit var disposable: Disposable

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_add)

//        Flowables


        val nameChangeObservable = RxTextView
                .textChanges(etName)
                .skip(1)
                .debounce(800, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .toFlowable(BackpressureStrategy.LATEST)

        val yearChangeObserver = RxTextView
                .textChanges(etYear)
                .skip(1)
                .debounce(800, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .toFlowable(BackpressureStrategy.LATEST) // pegando o ultimo click




        disposable = Flowables.combineLatest(
                nameChangeObservable,
                yearChangeObserver
        ) { newName: CharSequence,
            newYear: CharSequence ->
            val nameValid = newName.length > 3
            if (!nameValid) {
                etName.error = "Invalid name"
            }

            val yearValid = newYear.length == 4
            if (!yearValid) {
                etName.error = "Invalid Year"
            }



            nameValid && yearValid

        }.subscribe { formvalid ->

            btAdd.setBackgroundColor(ContextCompat.getColor(
                    applicationContext,
                    if (formvalid)
                        R.color.colorPrimaryDark
                    else R.color.gray
                )
            )​

            btAdd.setTextColor(
                    ContextCompat.getColor(
                            applicationContext,
                            if (formvalid)
                                R.color.white
                            else
                                R.color.black
                    )
            )
        }
    }
}




