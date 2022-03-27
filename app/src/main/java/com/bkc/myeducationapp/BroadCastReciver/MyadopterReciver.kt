package com.bkc.myeducationapp.BroadCastReciver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyadopterReciver : BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {
        p1?.apply {this
            var a= action?.equals("sendrequest")
        }
        TODO("Not yet implemented")
    }
}