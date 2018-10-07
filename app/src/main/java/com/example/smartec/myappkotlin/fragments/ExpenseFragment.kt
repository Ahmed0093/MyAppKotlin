package com.example.smartec.myappkotlin.fragments


import android.content.DialogInterface
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.example.smartec.myappkotlin.MainActivity

import com.example.smartec.myappkotlin.R
import com.example.smartec.myappkotlin.adapters.ExpenseCardAdapter
import com.example.smartec.myappkotlin.realm.RealmManager


/**
 * A simple [Fragment] subclass.
 *
 */
class ExpenseFragment : Fragment() {
    private var expenseRecyclerView: RecyclerView? = null
    lateinit var movieAdapter: ExpenseCardAdapter
    private var floatingBtn: FloatingActionButton? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
//        (activity as MainActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//        (activity as MainActivity).supportActionBar!!.setDisplayShowHomeEnabled(true)
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_expense, container, false)
        expenseRecyclerView = view.findViewById(R.id.explore)
        floatingBtn = view.findViewById(R.id.floatingActionButton)
        floatingBtn!!.setOnClickListener { _ ->
            feedback()
        }
        expenseRecyclerView!!.layoutManager = LinearLayoutManager(context)
        movieAdapter  = ExpenseCardAdapter(){item ->
            Toast.makeText(context,"itemid="+item.id, Toast.LENGTH_LONG).show()
            RealmManager().deleteById(item.id)
            movieAdapter.clearMovies()

        }
        expenseRecyclerView!!.adapter = movieAdapter



        movieAdapter.setRealmPayModel(RealmManager().findExpense())

        return view
    }

    private fun feedback() {

        val dialogBuilder = AlertDialog.Builder(activity as MainActivity)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.add_item_custom_dialog, null)
        dialogBuilder.setView(dialogView)

        val addedMoneyValue = dialogView.findViewById(R.id.money_to_add) as EditText
        val email = dialogView.findViewById(R.id.category_of_money) as EditText

        dialogBuilder.setTitle("Income")
        dialogBuilder.setMessage("Write a Category or it will be deafult")
        dialogBuilder.setPositiveButton("Add", DialogInterface.OnClickListener { dialog, _ ->
            val addedMoneyValueStr = addedMoneyValue.text.toString().trim { it <= ' ' }
            val emailStr = email.text.toString()
            if(!addedMoneyValueStr.isEmpty()) {
                RealmManager().insertExpense(addedMoneyValueStr,emailStr)
            }

        }


        )
        dialogBuilder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, _ ->
            //pass
        })

        val dialogCreate = dialogBuilder.create()
        dialogCreate.show()
    }
}
