package com.example.smartec.myappkotlin.realm

import com.example.smartec.myappkotlin.model.RealmExpenseModel
import com.example.smartec.myappkotlin.model.RealmPayModel
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmMigration

/**
 * Created by Ahmed Abdullah on 9/7/2018.
 */
class RealmManager {
    val realm: Realm by lazy {
        val config = RealmConfiguration.Builder()
                .name("bett.realm")
                .schemaVersion(3)
                .deleteRealmIfMigrationNeeded() // delete as you in middle of dev but in prod you have to make migration and update schema for each version !
                .build()
        Realm.getInstance(config)

      //  Realm.getDefaultInstance()
    }

    fun find(id: Long): RealmPayModel? {
        return realm.where(RealmPayModel::class.java).equalTo("id", id).findFirst()
    }

    fun findAll(): List<RealmPayModel> {
        return realm.where(RealmPayModel::class.java).findAll()
    }
    fun findExpense(): List<RealmExpenseModel> {
        return realm.where(RealmExpenseModel::class.java).findAll()
    }

    fun insert(title: String, content: String) {
        realm.beginTransaction()
        var newId: Long = 1
        if (realm.where(RealmPayModel::class.java).max("id") != null) {
            newId = realm.where(RealmPayModel::class.java).max("id") as Long + 1
        }
        val note = realm.createObject(RealmPayModel::class.java, newId)
        note.title = title
        note.category = content
        realm.commitTransaction()
    }
    fun insertExpense(title: String, content: String) {
        realm.beginTransaction()
        var newId: Long = 1
        if (realm.where(RealmExpenseModel::class.java).max("id") != null) {
            newId = realm.where(RealmExpenseModel::class.java).max("id") as Long + 1
        }
        val note = realm.createObject(RealmExpenseModel::class.java, newId)
        note.title = title
        note.category = content
        realm.commitTransaction()
    }

    fun update(id: Long, title: String, content: String) {
        realm.beginTransaction()
        val note = find(id)
        note?.title = title
        note?.category = content

        realm.commitTransaction()
    }

    fun deleteById(id: Long) {
        realm.beginTransaction()
        val results = realm.where(RealmPayModel::class.java!!).equalTo("id", id).findAll()
        results.deleteAllFromRealm()
        realm.commitTransaction()
    }
//    fun deleteByitem(model: RealmPayModel) {
//        realm.beginTransaction()
//        val results = realm.where(RealmPayModel::class.java!!).equalTo("id", model).findAll()
//        results.deleteAllFromRealm()
//        realm.commitTransaction()
//    }
}