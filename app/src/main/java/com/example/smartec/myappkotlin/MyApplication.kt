package com.example.smartec.myappkotlin

import android.app.Application
import io.realm.Realm

/**
 * Created by Ahmed Abdullah on 9/7/2018.
 */
class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this);
    }
}