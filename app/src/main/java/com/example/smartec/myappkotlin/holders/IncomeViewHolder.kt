package com.example.smartec.myappkotlin.holders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.smartec.myappkotlin.R
import kotlinx.android.synthetic.main.income_list_item.view.*

/**
 * Created by Ahmed Abdullah on 9/7/2018.
 */
class IncomeViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    private val holderImageview:ImageView = itemView.findViewById(R.id.item_image)
    private val holderTitleText:TextView = itemView.findViewById(R.id.item_text_title)
    private val moneyamount:TextView = itemView.findViewById(R.id.amount_of_money)


}