package com.example.smartec.myappkotlin.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by Ahmed Abdullah on 10/7/2018.
 */
open class RealmExpenseModel : RealmObject() {
    @PrimaryKey
    var id : Long = 0
    var title : String = ""
    var category :String = ""
}