package com.example.rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
     var disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /**
         * @param Flowable a type of emitter. it is the data to be observed. it handles many streams of data coming in by discarding the unnecesary ones
         * @param subscribeOn emits the data from the emitter on the background thread
         * @param observeOn sends the result to the main thread
         * @param subscribe listens for the result and prints it
         * @param disposables an instance of the Composite disposable class that removes memory and threads used by an observable
         */

         val flowable = Flowable.just("Ruth", "Paul", "Mary", "Usman")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe { value -> println(value) }

        disposables.add(flowable)


    }
}

