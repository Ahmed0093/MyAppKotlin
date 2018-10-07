package com.example.smartec.myappkotlin.fragments


import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.smartec.myappkotlin.R
import com.example.smartec.myappkotlin.adapters.IncomeCardAdapter
import com.example.smartec.myappkotlin.model.FakeDataTest
import com.example.smartec.myappkotlin.realm.RealmManager
import kotlinx.android.synthetic.main.fragment_income.*
import kotlinx.android.synthetic.main.income_list_item.*
import android.content.DialogInterface
import com.example.smartec.myappkotlin.MainActivity
import android.content.Intent
import android.support.v7.app.AlertDialog
import android.widget.EditText



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class IncomeFragment : Fragment() {
    private var incomeRecycler: RecyclerView? = null
    lateinit var movieAdapter: IncomeCardAdapter


        private var floatingBtn: FloatingActionButton? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
         val view =inflater.inflate(R.layout.fragment_income, container, false)
        incomeRecycler = view.findViewById(R.id.explore)
        floatingBtn = view.findViewById(R.id.floatingActionButton)
        floatingBtn!!.setOnClickListener { _ ->
            feedback()
        }
        incomeRecycler!!.layoutManager = LinearLayoutManager(context)
        movieAdapter  = IncomeCardAdapter(){item ->
            Toast.makeText(context,"itemid="+item.id,Toast.LENGTH_LONG).show()
            RealmManager().deleteById(item.id)
            movieAdapter.clearMovies()

        }
        incomeRecycler!!.adapter = movieAdapter



        movieAdapter.setRealmPayModel(RealmManager().findAll())




        return view
    }

    override fun onResume() {
        super.onResume()
                (activity as MainActivity).supportActionBar!!.hide()

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
                RealmManager().insert(addedMoneyValueStr,emailStr)
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
