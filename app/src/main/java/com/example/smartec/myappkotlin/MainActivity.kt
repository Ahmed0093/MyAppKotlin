package com.example.smartec.myappkotlin

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.smartec.myappkotlin.fragments.ExpenseFragment
import com.example.smartec.myappkotlin.fragments.IncomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val incomeFragment : IncomeFragment
    private val expenseFragment : ExpenseFragment

    init {
        incomeFragment =IncomeFragment()
        expenseFragment = ExpenseFragment()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> addFragment(incomeFragment)
            R.id.navigation_expense -> addFragment(expenseFragment)
            R.id.navigation_income -> addFragment(incomeFragment)


        }
        true
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()!!.setDisplayShowHomeEnabled(true);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
    /**
     * add/replace fragment in container [framelayout]
     */
    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
                .replace(R.id.frag_container, fragment, fragment.javaClass.getSimpleName())
//                .addToBackStack(fragment.javaClass.getSimpleName())
                .commit()
    }
}
