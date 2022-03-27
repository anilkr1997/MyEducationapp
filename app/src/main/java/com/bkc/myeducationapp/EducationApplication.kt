package com.bkc.myeducationapp

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context


class EducationApplication: Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        @JvmStatic
        private var sContext: Context? = null
    }



    private var sInstance: EducationApplication? = null


    @SuppressLint("MissingPermission")
    override fun onCreate() {
        super.onCreate()


//        MobileAds.setRequestConfiguration(
//                new RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList("E91521E781FBC1DA94D728005D03049B"))
//                        .build());
        sContext = applicationContext
        sInstance = this


        // The default Realm file is "default.realm" in Context.getFilesDir();
        // we'll change it to "myrealm.realm"

    }

    fun getContext(): Context? {
        return sContext
    }

    fun getInstance(): EducationApplication? {
        return sInstance
    }



}