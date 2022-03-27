package com.example.demod.RXCalling

/**
 * Created by Anil Tiwari on 15/12/2021.
 */
class ServiceModel : BaseModelData(), ServiceCallback {

    override fun onSuccess(o: Any) {
        notifyObservers(o)
    }

    override fun onFail(t: String) {
        notifyObservers(t)
    }


    fun doPostJSonRequest( serviceName: String) {
        ServiceRequests(this, serviceName).execute()
    }

    fun doPostJSonRequest(jsonValue : Any, serviceName: String) {
        ServiceRequests(this, serviceName, jsonValue).execute()
    }

    fun doPostJSonRequest(header : String, serviceName: String) {
        ServiceRequests(this, serviceName, header).execute()
    }

    fun doPostJSonRequest(jsonValue : Any,token : String, serviceName: String) {
        ServiceRequests(this, serviceName, jsonValue, token).execute()
    }

    fun doGetCheckStatusRequest(serviceName: String,url : String,header: String) {
        ServiceRequests(this,serviceName,url,header).execute()
    }

    fun doPostJSonRequest(myvalue : String,url : String, serviceName: String, token : String ) {
        ServiceRequests(this, serviceName, myvalue, url,token).execute()
    }
}
