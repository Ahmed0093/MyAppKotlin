package com.example.smartec.myappkotlin.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.smartec.myappkotlin.R
import com.example.smartec.myappkotlin.R.id.amount_of_money
import com.example.smartec.myappkotlin.holders.IncomeViewHolder
import com.example.smartec.myappkotlin.model.Paymodel
import com.example.smartec.myappkotlin.model.RealmExpenseModel
import com.example.smartec.myappkotlin.model.RealmPayModel
import kotlinx.android.synthetic.main.income_list_item.view.*

/**
 * Created by Ahmed Abdullah on 9/7/2018.
 */
class ExpenseCardAdapter(val listener: (RealmExpenseModel) -> Unit) :
        RecyclerView.Adapter<IncomeViewHolder>() {
    private var expensePaymodels: List<Paymodel> = ArrayList()
    private var expenseRealmpaylist: List<RealmExpenseModel> = ArrayList()


    override fun getItemCount(): Int {
        return expenseRealmpaylist.size
    }

    override fun onBindViewHolder(holder: IncomeViewHolder, position: Int) = with(holder.itemView) {
        val paymodel: RealmExpenseModel = expenseRealmpaylist[position]

        amount_of_money.text = paymodel.title
        item_text_title.text = paymodel.category
        setOnClickListener { listener(paymodel) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncomeViewHolder {
        var cardItem = LayoutInflater.from(parent.context).inflate(R.layout.income_list_item,parent,false)
        return IncomeViewHolder(cardItem)
    }

    fun setPayModel (movies: List<Paymodel>){
        this.expensePaymodels = movies
        this.notifyDataSetChanged()
    }
    fun setRealmPayModel (movies: List<RealmExpenseModel>){
        this.expenseRealmpaylist = movies
        this.notifyDataSetChanged()
    }

    fun clearMovies() {
        expensePaymodels = ArrayList()
        this.notifyDataSetChanged()
    }
}