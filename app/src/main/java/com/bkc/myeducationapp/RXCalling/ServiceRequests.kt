package com.example.demod.RXCalling

import android.content.Context
import com.bkc.myeducationapp.utility.Utility.GETALLCOURCES
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/**
 * Created by Anil Tiwari on 15/12/2021.
 */
class ServiceRequests {

    private var serviceName = ""
    private var serviceInterface: ServiceInterface? = null
    private var serviceResponseInterface: ServiceCallback? = null
    private var stringHashMap: HashMap<String, String>? = null
    private var jsonValue: Any? = null
    private var jsonValue2: Any? = null
    private var paymentToken: String? = null
    private var Header: String? = null
    private var url: String? = null
    private var myvalue: String? = null
    var response: Observable<*>? = null

    constructor(observable: java.util.Observable, stringHashMap: HashMap<String, String>, serviceName: String) {
        this.serviceResponseInterface = observable as ServiceCallback
        this.serviceName = serviceName
        this.stringHashMap = stringHashMap
    }

    constructor(observable: java.util.Observable, stringHashMap: HashMap<String, String>, serviceName: String, header: String) {
        this.serviceResponseInterface = observable as ServiceCallback
        this.serviceName = serviceName
        this.stringHashMap = stringHashMap
        this.Header = header
    }

    constructor(observable: java.util.Observable, serviceName: String) {
        this.serviceResponseInterface = observable as ServiceCallback
        this.serviceName = serviceName
    }

    constructor(observable: java.util.Observable, serviceName: String, jsonValue: Any) {
        this.serviceResponseInterface = observable as ServiceCallback
        this.serviceName = serviceName
        this.jsonValue = jsonValue
    }


    constructor(observable: java.util.Observable, serviceName: String, header: String) {
        this.serviceResponseInterface = observable as ServiceCallback
        this.serviceName = serviceName
        this.Header = header
    }

    constructor(observable: java.util.Observable, serviceName: String, jsonValue: Any, header: String) {
        this.serviceResponseInterface = observable as ServiceCallback
        this.serviceName = serviceName
        this.jsonValue = jsonValue
        this.Header = header
    }

    constructor(observable: java.util.Observable, serviceName: String, url: String, header: String) {
        this.serviceResponseInterface = observable as ServiceCallback
        this.serviceName = serviceName
        this.url = url
        this.Header = header
    }

    constructor(observable: java.util.Observable, serviceName: String, value: String, url: String,header : String ) {
        this.serviceResponseInterface = observable as ServiceCallback
        this.serviceName = serviceName
        this.url = url
        this.myvalue = value
        this.Header = header
    }


    fun execute() {
        serviceInterface = ApiClient.client!!.create(ServiceInterface::class.java)
        doRequest()
    }
    fun execute( myvalue: String) {
        this.myvalue = myvalue
        serviceInterface = ApiClient.client!!.create(ServiceInterface::class.java)
        doRequest()
    }

    fun execute(context: Context) {
        serviceInterface = ApiClient.client!!.create(ServiceInterface::class.java)
        doRequest()
    }


    private fun doRequest() {
        if (serviceName == GETALLCOURCES) {
            response = serviceInterface!!.GetAllCource()
        }
//  else if (serviceName == "GetAccessToken") {
//            response = serviceInterface!!.GetAccessToken(
//                jsonValue
//            )
//        }
//  else if (serviceName == "AddProfile") {
//            response = serviceInterface!!.AddProfile(
//                Header!!,jsonValue
//            )
//        }
//  else if (serviceName == "AddQualification") {
//            response =serviceInterface!!. AddQualification(
//                Header!!,jsonValue
//            )
//        }
//  else if (serviceName == "AddRegistration") {
//            response = serviceInterface!!.AddRegistration(
//                Header!!,jsonValue
//            )
//        }
//  else if (serviceName == "AddBankDetails") {
//            response = serviceInterface!!.AddBankDetails(
//                Header!!,jsonValue
//            )
//        }
//  else if (serviceName == "GetProfile") {
//            response = serviceInterface!!.GetProfile(
//                Header!!,url!!
//            )
//        }
//  else if (serviceName == "GetAppoitmentHistory") {
//            response = serviceInterface!!.getappohis(
//               Header!!, url!!, myvalue!!
//            )
//        }
//
//
//
//        else if (serviceName == "AddSlot") {
//            response = serviceInterface!!.AddSlot(
//                Header!!,jsonValue
//            )
//        }
//
//
//        else if (serviceName == "GetDoctorAppointmentEarning") {
//            response = serviceInterface!!.GetDoctorAppointmentEarning(
//                Header!!, url!!, myvalue!!
//            )
//        }
//
//        else if (serviceName == "GetQualification") {
//            response = serviceInterface!!.GetQualification(
//                Header!!, url!!, myvalue!!
//            )
//        }
//
//        else if (serviceName == "GetRegistration") {
//            response = serviceInterface!!.GetRegistration(
//                Header!!, url!!, myvalue!!
//            )
//        }


        /* else if (serviceName == "AddProfile") {
                   response = serviceInterface!!.AddProfile(
                       jsonValue
                   )
               }*/

        response!!.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { o -> o }
                .subscribe(Consumer<Any> { this.handleResults(it) }, Consumer<Throwable> { this.handleError(it) })
    }

    private fun handleResults(o: Any) {
//        Log.e("responsechcek>>", "response from service");
        serviceResponseInterface!!.onSuccess(o)

    }

    private fun handleError(t: Throwable) {
        serviceResponseInterface!!.onFail(t.message!!)
    }

}
