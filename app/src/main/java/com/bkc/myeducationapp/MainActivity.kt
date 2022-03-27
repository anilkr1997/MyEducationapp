package com.bkc.myeducationapp

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import butterknife.ButterKnife
import com.bkc.myeducationapp.Fragment.HomeFragment
import com.changesNewDesignsDiary.BaseActivityKot
import java.util.*

class MainActivity : BaseActivityKot() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar(this)
        setSupportActionBar(toolbar)
        setFragment(HomeFragment.newInstance(this),true,this,R.id.flFragment)
    }

    override fun getModel(): Observable {
      return  serviceModel
    }

    override fun update(p0: Observable?, obj: Any?) {
        TODO("Not yet implemented")
    }
}