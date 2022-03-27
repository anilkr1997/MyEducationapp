package com.example.demod.RXCalling

import com.bkc.myeducationapp.ModelClass.courcelist.Courcelist
import io.reactivex.Observable
import retrofit2.http.GET


/**
 * Created by Anil Tiwari on 15/12/2021.
 */

interface ServiceInterface {

    companion object {
              val BASE_URL = "https://online.omitec.org/elearn-api2/"
    }



   @GET("Course/getCourse")
   fun GetAllCource(): Observable<Courcelist>


/*    @Headers("Content-Type: application/json")
    @GET
   fun GetProfile(@Header("Authorization") Authorization: String, @Url url: String): Observable<GetProfile>


   @POST("Auth/GetAccessToken")
   fun GetAccessToken(@Body any: Any?): Observable<GetToken>


   @Headers("Content-Type: application/json")
    @POST("Doctor/profile/AddProfile")
   fun AddProfile(@Header("Authorization") Authorization: String, @Body any: Any?): Observable<AddProfile>

   @Headers("Content-Type: application/json")
    @POST("Doctor/profile/AddQualification")
   fun AddQualification(@Header("Authorization") Authorization: String, @Body any: Any?): Observable<AddQualification>


   @Headers("Content-Type: application/json")
    @POST("Doctor/profile/AddRegistration")
   fun AddRegistration(@Header("Authorization") Authorization: String, @Body any: Any?): Observable<CommonResposne>

   @Headers("Content-Type: application/json")
    @POST("Doctor/profile/AddBankDetails")
   fun AddBankDetails(@Header("Authorization") Authorization: String, @Body any: Any?): Observable<CommonResposne>


    @Headers("Content-Type: application/json")
    @GET
    fun getappohis(@Header("Authorization") Authorization: String, @Url url: String,@Query("profileId") input: String): Observable<AppoHisResponse>


    @Headers("Content-Type: application/json")
    @POST("Doctor/schedule/AddSlot")
    fun AddSlot(@Header("Authorization") Authorization: String, @Body any: Any?): Observable<CommonResposne>

    @Headers("Content-Type: application/json")
    @GET
    fun GetDoctorAppointmentEarning(@Header("Authorization") Authorization: String, @Url url: String,@Query("profileId") input: String?): Observable<AppointmentResponse>

    @Headers("Content-Type: application/json")
    @GET
    fun GetQualification(@Header("Authorization") Authorization: String, @Url url: String,@Query("profileId") input: String?): Observable<DrQualificationResponse>

    @Headers("Content-Type: application/json")
    @GET
    fun GetRegistration(@Header("Authorization") Authorization: String, @Url url: String,@Query("profileId") input: String): Observable<DrRegResponse>


    @POST("UesrTest/GetUserTestByMedicalTestId")
   fun GetUserTestByMedicalTestId(@Body any: Any?): Observable<String>*/




}

