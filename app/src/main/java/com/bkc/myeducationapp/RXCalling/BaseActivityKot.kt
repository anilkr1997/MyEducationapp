package com.changesNewDesignsDiary

import android.R
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
/*import android.support.v7.app.AppCompatActivity*/
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import java.util.*
import com.example.demod.RXCalling.ServiceModel
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.bkc.myeducationapp.Fragment.HomeFragment


/**
 * Created by Anil Tiwari on 15/12/2021.
 */

abstract class BaseActivityKot : AppCompatActivity(), Observer {
    var toolbar: Toolbar? = null
    var serviceModel = ServiceModel()
    var mycustomdialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model = getModel()
        model.addObserver(this)
    }

    abstract fun getModel(): Observable
    open fun initToolbar(activity: Activity): Toolbar? {
        toolbar =findViewById(com.bkc.myeducationapp.R.id.toolbar)
        toolbar!!.setNavigationIcon(ContextCompat.getDrawable(activity, com.bkc.myeducationapp.R.drawable.ic_baseline_menu_24))

        toolbar!!.setTitleTextColor(resources.getColor(R.color.white))
        toolbar!!.setNavigationOnClickListener(View.OnClickListener { this.onBackPressed() })
        toolbar!!.setVisibility(View.VISIBLE)
        return toolbar
    }



    companion object {

        @JvmStatic
        public fun setFragment(fragment: Fragment, removeStack: Boolean, activity: FragmentActivity, mContainer: Int) {
            val fragmentManager: FragmentManager = activity.supportFragmentManager
            val ftTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            ftTransaction.setCustomAnimations(
                com.bkc.myeducationapp.   R.anim.enter_from_right,
                com.bkc.myeducationapp.   R.anim.exit_to_left,
                com.bkc.myeducationapp.   R.anim.enter_from_left,
                com.bkc.myeducationapp.   R.anim.exit_to_right
            )
            if (removeStack) {
                val size: Int = fragmentManager.getBackStackEntryCount()
                fragmentManager.popBackStack(
                    fragment.getTag(),
                    FragmentManager.POP_BACK_STACK_INCLUSIVE
                )
                ftTransaction.replace(mContainer, fragment)
            } else {
                ftTransaction.replace(mContainer, fragment)
                ftTransaction.addToBackStack(fragment.getTag())
            }
            ftTransaction.commit()
        }

    }
}
