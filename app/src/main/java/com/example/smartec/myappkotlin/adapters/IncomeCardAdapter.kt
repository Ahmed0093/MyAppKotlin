package com.example.smartec.myappkotlin.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.smartec.myappkotlin.R
import com.example.smartec.myappkotlin.R.id.amount_of_money
import com.example.smartec.myappkotlin.holders.IncomeViewHolder
import com.example.smartec.myappkotlin.model.Paymodel
import com.example.smartec.myappkotlin.model.RealmPayModel
import kotlinx.android.synthetic.main.income_list_item.view.*

/**
 * Created by Ahmed Abdullah on 9/7/2018.
 */
class IncomeCardAdapter(val listener: (RealmPayModel) -> Unit) :
        RecyclerView.Adapter<IncomeViewHolder>() {
    private var paymodels: List<Paymodel> = ArrayList()
    private var realmpaylist: List<RealmPayModel> = ArrayList()


    override fun getItemCount(): Int {
        return realmpaylist.size
    }

    override fun onBindViewHolder(holder: IncomeViewHolder, position: Int) = with(holder.itemView) {
        val paymodel: RealmPayModel = realmpaylist[position]

        amount_of_money.text = paymodel.title
        item_text_title.text = paymodel.category
        setOnClickListener { listener(paymodel) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncomeViewHolder {
        var cardItem = LayoutInflater.from(parent.context).inflate(R.layout.income_list_item,parent,false)
        return IncomeViewHolder(cardItem)
    }

    fun setPayModel (movies: List<Paymodel>){
        this.paymodels = movies
        this.notifyDataSetChanged()
    }
    fun setRealmPayModel (movies: List<RealmPayModel>){
        this.realmpaylist = movies
        this.notifyDataSetChanged()
    }

    fun clearMovies() {
        paymodels = ArrayList()
        this.notifyDataSetChanged()
    }
}