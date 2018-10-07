package com.example.smartec.myappkotlin.model

import android.app.Application

/**
 * Created by Ahmed Abdullah on 9/7/2018.
 */
class FakeDataTest(){
     private var paymodellist: MutableList<Paymodel> = mutableListOf<Paymodel>()
    private var paymodellist2: MutableList<RealmPayModel> = mutableListOf<RealmPayModel>()




    fun getAll (): List<Paymodel>{
         paymodellist.add(Paymodel("date1","title1","img1","s"))
         paymodellist.add(Paymodel("date1","title1","img1","s"))
         paymodellist.add(Paymodel("date1","title1","img1","s"))
         paymodellist.add(Paymodel("date1","500&","img1","Clothes"))
         paymodellist.add(Paymodel("date1","400$","img1","Meat"))


         return paymodellist
     }

    fun getAll2 (): List<RealmPayModel>{
        paymodellist2.add(RealmPayModel())
        paymodellist.add(Paymodel("date1","title1","img1","s"))
        paymodellist.add(Paymodel("date1","title1","img1","s"))
        paymodellist.add(Paymodel("date1","500&","img1","Clothes"))
        paymodellist.add(Paymodel("date1","400$","img1","Meat"))


        return paymodellist2
    }
    fun clearAll():List<Paymodel>
    {
        paymodellist = mutableListOf<Paymodel>()
        return paymodellist
    }

    fun getByDate (id: String) = getAll().firstOrNull{it.date == id} ?: throw PaymodelNotFoundException()

    class PaymodelNotFoundException : Exception("Pay not found") {
    }
//            pay.add(Paymodel("1-1","Clothes","IMG","500dollar"))
//
//            movies.add(Movie(3, "Star Trek Beyond", "" + baseAddress + "doqRJwhRFsHHneYG82bM0hSTqpz.jpg", "The USS Enterprise crew explores the furthest reaches of uncharted space, where they encounter a mysterious new enemy who puts them and everything the Federation stands for to the test."))
//            movies.add(Movie(4, "Doctor Strange", baseAddress + "2wgKgQAqso1p1yP6unsq9nl7Xdc.jpg", "After his career is destroyed, a brilliant but arrogant surgeon gets a new lease on life when a sorcerer takes him under his wing and trains him to defend the world against evil."))
//            movies.add(Movie(5, "The Girl on the Train", baseAddress + "fpq86AP0YBYUwNgDvUj5kxwycxH.jpg", "Rachel Watson, devastated by her recent divorce, spends her daily commute fantasizing about the seemingly perfect couple who live in a house that her train passes every day, until one morning she sees something shocking happen there and becomes entangled in the mystery that unfolds."))
//            movies.add(Movie(6, "Deepwater Horizon", baseAddress + "zjYdnBHbIOYBqKZxvBUsT5MevUA.jpg", "A story set on the offshore drilling rig Deepwater Horizon, which exploded during April 2010 and created the worst oil spill in U.S. history."))
//            movies.add(Movie(7, "A Monster Calls", baseAddress + "xVW8REyVqKwxAtUYY07UGlZH43L.jpg", "A boy attempts to deal with his mother's illness and the bullying of his classmates by escaping to a fantastical world."))
//
//            simulateDelay();
//
//            return movies.toList()
//        }
//
//        private fun simulateDelay() {
//            try {
//                Thread.sleep(2000)
//            } catch (e: InterruptedException) {
//                e.printStackTrace()
//            }
//
//        }
//
//        override fun getById (id: Long) = getAll().firstOrNull{it.id == id} ?: throw MovieNotFoundException()
//    }

}