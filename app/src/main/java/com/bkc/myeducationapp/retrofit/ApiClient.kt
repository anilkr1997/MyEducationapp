package com.bkc.myeducationapp.retrofit

import com.bkc.myeducationapp.EducationApplication
import com.bkc.myeducationapp.utility.NetworkUtils
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

class ApiClient {
    // Main Link
    val BASE_URL = "http://103.205.64.197/fasalsalahgold/"


    private var retrofit: Retrofit? = null
    private val ourInstance = ApiClient()

    fun getInstance(): ApiClient? {
        return ourInstance
    }

    /**
     * prepare api client setup for one time only.
     *
     * @return api service.
     */
    fun getApiService(): ApiService? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
        return retrofit!!.create(ApiService::class.java)
    }


    /**
     * prepared custom client here.
     *
     * @return OkHttpClient.
     */
    private fun getClient(): OkHttpClient? {
        return OkHttpClient.Builder()
            .addInterceptor(getInterceptor()!!)
            .addInterceptor(object : Interceptor {
                @Throws(IOException::class)
                override fun intercept(chain: Interceptor.Chain): Response {
                    if (!NetworkUtils.isOnline(EducationApplication().getContext())) {
                        throw NoConnectivityException()
                    }
                    val original: Request = chain.request()
                    val request =
                        original.newBuilder() //                                .header("CLIENT-OS", "ANDROID")
                            .method(original.method, original.body)
                            .build()
                    return chain.proceed(request)
                }
            })
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    /**
     * get interceptor here.
     *
     * @return Interceptor.
     */
    private fun getInterceptor(): Interceptor? {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return interceptor
    }
}