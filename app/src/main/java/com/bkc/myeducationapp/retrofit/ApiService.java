//package com.bkc.myeducationapp.retrofit;
//
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import io.reactivex.Observable;
//import okhttp3.MultipartBody;
//import okhttp3.RequestBody;
//import okhttp3.ResponseBody;
//import retrofit2.Call;
//import retrofit2.Response;
//import retrofit2.http.Body;
//import retrofit2.http.GET;
//import retrofit2.http.Multipart;
//import retrofit2.http.POST;
//import retrofit2.http.Part;
//import retrofit2.http.PartMap;
//import retrofit2.http.Path;
//import retrofit2.http.Url;
//
//
//public interface ApiService {
////    @GET("global/registration/getLanguage/{countryId}")
////    Observable<ArrayList<Language>> getLanguages(@Path("countryId") String countryId);
////
////    @GET("registration3/checkTrialSubscription/{phoneNo}")
////    Observable<ArrayList<String>> getFreeMember();
////
////    @GET("getState")
////    Observable<ArrayList<String>> getAllStates();
////
////    @GET("getstates")
////    Observable<ArrayList<State>> getAllStatesWithId();
////
////    @GET("getDist/{state}")
////    Observable<ArrayList<String>> getAllDistricts(@Path("state") String state);
////
////    @GET("getdistricts/{id}")
////    Observable<ArrayList<District>> getAllDistricts(@Path("id") int state);
////
////    @GET("getStn/{state}/{district}")
////    Observable<ArrayList<String>> getAllTehsils(@Path("state") String state, @Path("district") String district);
////
////    @GET("getVillage/{state}/{district}/{tehsil}")
////    Observable<ArrayList<Village>> getAllVillages(@Path("state") String state, @Path("district") String district, @Path("tehsil") String tehsil);
////
////    @GET("registration3/addcropveriety/{lang}")
////    Observable<ArrayList<Crop>> getAllCrops(@Path("lang") String lang);
////
////    @GET("registration3/getNewCrops2/{mobile}")
////    Observable<ArrayList<Crop>> getCrops(@Path("mobile") String mobile);
////
////    @POST("registration3/saveUser")
////    Observable<User> registerUser(@Body User user);
////
////    @GET("home/advertisement/{mobileNumber}/{token}")
////    Observable<Advertisement> getAdvertisement(@Path("mobileNumber") String mobileNumber, @Path("token") String token);
////
////    @GET("forecast3/getForecast/{mobile}/{lat}/{lng}/{village}/{state}")
////    Observable<ArrayList<Weather>> getWeatherForcasting(@Path("mobile") String mobileNumber, @Path("lat") String lat, @Path("lng") String lng, @Path("village") String village, @Path("state") String state);
////
////    @GET("news2/getweathernews/{mobile}/{lang}")
////    Observable<News> getNewsReport(@Path("mobile") String mobileNumber, @Path("lang") String language);
////
////    @GET("news3/getNews/{newsId}")
////    Observable<News> getNews(@Path("newsId") String mobileNumber);
////
////    @GET("news2/getNewsImage/{mobile}/{lang}/0")
////    Observable<ArrayList<News>> getNewsImage(@Path("mobile") String mobileNumber, @Path("lang") String language);
////
////    @GET("news3/getTopNews/{lang}")
////    Observable<ArrayList<News>> getTopNews(@Path("lang") String language);
////
////    @GET("news2/schemes/{mobile}/{lang}")
////    Observable<ArrayList<News>> getGovetnmentScheme(@Path("mobile") String mobileNumber, @Path("lang") String language);
////
////    @GET("news2/getIncomeImageList/{mobile}/{lang}/0")
////    Observable<ArrayList<News>> getDoubleIncomeList(@Path("mobile") String mobileNumber, @Path("lang") String language);
////
////    @GET("feedback3/getsuccessstories/{mobile}/{lang}/0")
////    Observable<ArrayList<News>> getSuccessStories(@Path("mobile") String mobileNumber, @Path("lang") String language);
////
////
////    @GET("forecast3/getdistrictforecast3/{mobile}/{stateId}/{districtId}/{districtName}")
////    Observable<ArrayList<Weather>> getWeatherForecast(@Path("mobile") String mobileNumber, @Path("stateId") int stateid, @Path("districtId") int districtId, @Path("districtName") String districtName);
////
////    @GET("global/registration/getusercrop/{mobile}/{languageId}")
////    Observable<ArrayList<Crop>> getUserCrops(@Path("mobile") String mobileNumber, @Path("languageId") String languageId);
////
////
////    @GET("registration3/getusercrop/{cropId}/{varietyId}/{mobile}/{languageId}")
////    Observable<ArrayList<Crop>> getUserCrops(@Path("cropId") String cropId, @Path("varietyId") String varietyId, @Path("mobile") String mobileNumber, @Path("languageId") String languageId);
////
////    @GET("registration3/getvariety2/{mobile}/{cropId}/{languageId}")
////    Observable<ArrayList<Variety>> getVariety(@Path("mobile") String mobileNumber, @Path("cropId") String cropId, @Path("languageId") String languageId);
////
////    @GET("advisory2/getirrigationlist/{mobile}/{languageId}")
////    Observable<ArrayList<AreaType>> getAreaType(@Path("mobile") String mobileNumber, @Path("languageId") String languageId);
////
////    //    @POST("registration3/addcropvariety3/")
//////    Observable<BaseResponse> addCrop(@Body Crop crop);
////    @POST("registration3/addUserCrop/")
////    Observable<BaseResponse> addCrop(@Body Crop crop);
////
////    //    @GET("editdetails/deleteCropfromusercrop/{mobile}/{cropId}/{varietyId}")
//////    Observable<BaseResponse> deleteCrop(@Path("mobile") String mobile, @Path("cropId") int cropId, @Path("varietyId") int varietyId);
////    @GET("registration3/deleteUserCrop/{mobile}/{cropId}/{varietyId}/{siteId}")
////    Observable<BaseResponse> deleteCrop(@Path("mobile") String mobile, @Path("cropId") int cropId, @Path("varietyId") int varietyId, @Path("siteId") int siteId);
////
////    @POST("registration3/editsowingdatevariety3")
////    Observable<BaseResponse> updateCrop(@Body Crop crop);
////
////    //    @GET("multiLingAdvisory/getAdvisory/{mobile}/{cropId}/{lat}/{lon}/{village}/{languageId}/{varietyId}")
////    @GET("advisory3/getAdvisory/{mobile}/{cropId}/{lat}/{lon}/{village}/{languageId}/{varietyId}/{siteId}")
////    Observable<CropAdvisory> getCropAdvisory(@Path("mobile") String mobile, @Path("cropId") int cropId, @Path("lat") String lat, @Path("lon") String lon, @Path("village") String village, @Path("languageId") String languageId, @Path("varietyId") String varietyId, @Path("siteId") String siteId);
////
////    @GET("advisory2/getcropdetailedinformation/{cropId}/{varietyId}/{languageId}")
////    Observable<ArrayList<CropDetailedInfromation>> getCropDetailedInformation(@Path("cropId") int cropId, @Path("varietyId") int varietyId, @Path("languageId") String languageId);
////
////    @GET
////    Observable<ArrayList<Shop>> getNearestShopDetails(@Url String url);
////
////    @Multipart
////    @POST("editdetails/uploadFile2")
////    Observable<FileUploadResponse> fileUpload(@Part MultipartBody.Part image);
////
////    @POST("editdetails/addshop")
////    Observable<BaseResponse> addShop(@Body AddShopRequest addShopRequest);
////
////    @GET("news2/jobs/{phoneNo}/{languageId}/{jobType}")
////    Observable<ArrayList<Job>> getJobs(@Path("phoneNo") String mobile, @Path("languageId") String languageId, @Path("jobType") String jobType);
////
////    @GET("news3/getjobs/{jobId}")
////    Observable<ArrayList<Job>> getJobs(@Path("jobId") String jobId);
////
////    @POST("news2/setUserContents")
////    Observable<BaseResponse> sendAdvice(@Body AdviceRequest adviceRequest);
////
////    @GET("registration3/checkphoneno/{mobile}/{fcmTokem}/Android")
////    Observable<User> checkMobileNumber(@Path("mobile") String mobile, @Path("fcmTokem") String fcmToken);
////
////    @GET("mandi3/cropsCategory/{mobile}/{language}")
////    Observable<ArrayList<MandiCategory>> getMandiCategory(@Path("mobile") String mobile, @Path("language") String language);
////
////    @GET("mandi3/cropsSubCategory/{category}/{language}")
////    Observable<ArrayList<MandiCrop>> getMandiCrops(@Path("category") String category, @Path("language") String language);
////
////    @GET("mandi3/getMandi3/{mobile}/{cropName}/{lat}/{lon}/{state}")
////    Observable<Mandi> getMandiRates(@Path("mobile") String mobile,
////                                    @Path("cropName") String cropName,
////                                    @Path("lat") double latitude,
////                                    @Path("lon") double longitude,
////                                    @Path("state") String state);
////
////    @GET("othermandistates/{cropName}")
////    Observable<ArrayList<String>> getOtherMandiStates(@Path("cropName") String cropName);
////
////    @GET("othermandidistrictswithcrop/{state}/{cropName}")
////    Observable<ArrayList<String>> getOtherMandi(@Path("state") String state, @Path("cropName") String cropName);
////
////    @GET("mandi3/othermandimap3/{state}/{mandi}/{cropName}")
////    Observable<Mandi> getOtherMandiRates(@Path("state") String state,
////                                         @Path("mandi") String mandi,
////                                         @Path("cropName") String cropName);
////
////    @Multipart
////    @POST("registration3/userSaveCropImage")
////    Observable<FileUploadResponse> saveCropImage(@Part MultipartBody.Part image, @PartMap Map<String, RequestBody> partMap);
//////    @POST("editdetails/savecropimage3")
//////    Observable<FileUploadResponse> saveCropImage(@Part MultipartBody.Part image);
////
////    @Multipart
////    @POST("registration3/userSaveCropImage")
////    Call<FileUploadResponse> fileUploadBackground(@Part MultipartBody.Part image, @PartMap Map<String, RequestBody> partMap);
//////    @POST("editdetails/savecropimage3")
//////    Call<FileUploadResponse> fileUploadBackground(@Part MultipartBody.Part image);
////
////    @POST("feedback/savecropfieldtext2")
////    Observable<BaseResponse> sendInsuranceDetails(@Body InsuranceRequest insuranceRequest);
////
////    @POST("feedback/savecropfieldtext2")
////    Call<BaseResponse> sendInsuranceDetailsBackground(@Body InsuranceRequest insuranceRequest);
////
////    @GET("getchartmandi/{mobile}/{cropName}")
////    Observable<MandiChartResponse> getMandiChartData(@Path("mobile") String mobile, @Path("cropName") String cropName);
////
////    @GET("feedback3/getuserpost/{mobile}/{languageId}")
////    Observable<ArrayList<UserPost>> getUserPost(@Path("mobile") String mobile, @Path("languageId") String languageId);
////
////    @GET("feedback3/getpostofuser/{postId}/{mobile}")
////    Observable<ArrayList<UserPost>> getPostOfUser(@Path("mobile") String mobile, @Path("postId") String postId);
////
////    @POST("feedback/savelikeby")
////    Observable<BaseResponse> likeUserPost(@Body LikeRequest likemandiRequest);
////
////    @GET("feedback/getusercomment/{mobile}/{postId}/{languageId}")
////    Observable<ArrayList<Comments>> getPostComments(@Path("mobile") String mobile, @Path("postId") String postId, @Path("languageId") String languageId);
////
////    @POST("feedback/saveUserComment")
////    Observable<BaseResponse> saveUserComment(@Body Comments comments);
////
////    @Multipart
////    @POST("feedback3/savepostimage")
////    Observable<FileUploadResponse> uploadPostImage(@Part MultipartBody.Part image);
////
////    @POST("feedback/saveUserPost")
////    Observable<BaseResponse> addUserPost(@Body AddUserPostRequest addUserPostRequest);
////
////    @GET("registration/saveuserlanguage/{mobile}/{languageId}")
////    Observable<BaseResponse> changeLanguage(@Path("mobile") String mobile, @Path("languageId") String language);
////
////    @GET("edit/updateUserName/{mobile}/{name}")
////    Observable<BaseResponse> changeName(@Path("mobile") String mobile, @Path("name") String language);
////
////    @POST("registration3/changeLocation")
////    Observable<User> changeLocation(@Body User user);
////
////    @POST("editdetails/updateUserToken")
////    Call<BaseResponse> updateUserToken(@Body UpdateFCMRequest updateFCMRequest);
////
////    @GET("editdetails/getVersion/FasalSalah/Android")
////    Observable<AppVersionResponse> getAppVersion();
////
////    @GET("registration3/terms/{language}")
////    Observable<TermsAndConditions> getTermsAndCondition(@Path("language") String language);
////
////    @GET("registration3/getuserVarietyList/{mobile}/{language}")
////    Observable<ArrayList<CropStatus>> getUserVarietyList(@Path("mobile") String mobile, @Path("language") String language);
////
////    //TODO: New Changes made
////
////    @GET("forecast3/getForecast/{lat}/{lng}/{address}")
////    Observable<ArrayList<Weather>> getWeatherForecast(@Path("lat") String lat, @Path("lng") String lng, @Path("address") String address);
////
////    @GET("gateWay/generateOTP/{mobile}/{countrycode}")
////    Observable<BaseResponse> sendMessage(@Path("mobile") String mobile, @Path("countrycode") String countrycode);
////
////    @POST("gateWay/verifyPhoneNo")
////    Observable<User> verifyOtp(@Body LoginRequest loginRequest);
////
////    @POST("gateWay/checkNumberExist/{phoneNo}")
////    Observable<ReportModel> userlogin(@Path("phoneNo") String phonenumber);
////
////    @POST("gateWay/getAllUserInfo/{phoneNo}/{token}")
////    Observable<User> userDetail(@Path("phoneNo") String phonenumber, @Path("token") String token);
////
////
////    @GET("buyerseller/getcategorylist/{mobile}")
////    Observable<ArrayList<BuyerSellerCategory>> getBuyerSellerCategories(@Path("mobile") String mobile);
////
////    @GET("buyerseller/getsubcategorylist/{categoryId}/{mobile}")
////    Observable<ArrayList<ItemCategory>> getBuyerSellerSubcategories(@Path("categoryId") int categoryId, @Path("mobile") String mobile);
////
////    @GET("buyerseller/getitemlist/{categoryId}/{subcategoryId}/{mobile}")
////    Observable<ArrayList<BuyerSellerItems>> getBuyerSellerItems(@Path("categoryId") int categoryId, @Path("subcategoryId") int subcategoryId, @Path("mobile") String mobile);
////
////    @POST("astro/addAstroUser")
////    Observable<BaseResponse> sendAstrologyQuery(@Body AstrologyQueryRequest astrologyQueryRequest);
////
////    @GET("astro/getAstroUserDetails/{mobile}")
////    Observable<ArrayList<AstrologyQueryResult>> getAstroQueryResult(@Path("mobile") String mobile);
////
////
////    @GET("feedback3/getuserpostforpage/{mobile}/{languageId}")
////    Observable<ArrayList<UserPost>> getRecentUserPost(@Path("mobile") String mobile, @Path("languageId") String languageId);
////
////    @POST("registration3/getGhostImage")
////    Observable<BaseResponse> getGhostImage(@Body Crop crop);
////
////    @Multipart
////    @POST("video/uploadUserVideo")
////    Call<FileUploadResponse> videoUploadBackground(@Part MultipartBody.Part image, @PartMap Map<String, RequestBody> partMap);
////
////    @GET("video/getVideoDetails/video")
////    Observable<ArrayList<Video>> getVideoList();
////
////    @POST("news3/userPostNews")
////    Observable<BaseResponse> addUserNews(@Body News news);
////
////    @Multipart
////    @POST("news3/saveUserNewsImage")
////    Observable<FileUploadResponse> newImageUpload(@Part MultipartBody.Part image);
////
////    @GET("registration3/referToUser/{mobile}/{refferalCode}")
////    Observable<BaseResponse> sendReferralCode(@Path("mobile") String mobile, @Path("refferalCode") String refferalCode);
////
////    @GET("registration3/getReferralCount/{mobile}")
////    Observable<Referral> getReferralCode(@Path("mobile") String mobile);
////
////    @GET("gateWay/userSubscriptionDetails/{languageId}/{tag}/{mobile}")
////    Observable<PaymentDetails> getPaymentDetails(@Path("languageId") String languageId, @Path("tag") String tag, @Path("mobile") String mobile);
////
////    @POST("gateWay/generateHash")
////    Observable<BaseResponse> getHashKey(@Body HashKeyRequest hashKeyRequest);
////
////    @POST("gateWay/updateSubscriptionStatus")
////    Observable<BaseResponse> onPaymentSuccess(@Body PaymentSuccess paymentSuccess);
////
////    @POST("advisory3/userCropFeedback")
////    Observable<BaseResponse> sendCropAdvisoryFeedback(@Body CropAdvisoryFeedback cropAdvisoryFeedback);
////
////    @GET("editdetails/appbanner/hi")
////    Call<List<BannerModel>> getPoster();
////
////    @GET("editdetails/advertisementbanner/{stateId}/{districtId}/{languageId}")
////    Observable<BannerResponse> getPromotions(@Path("stateId") int stateId, @Path("districtId") int districtId, @Path("languageId") String languageId);
////
////    //TODO: New Changes made date on 1 july 2021
////    @GET("home/showall/{Mobilenumber}/{luanguageid}/0/{stateid}/{Districtid}")
////    Observable<Alldataformhome> getAllHomeData(@Path("Mobilenumber") String Mobilenumber, @Path("luanguageid") String luanguageid, @Path("stateid") int stateid, @Path("Districtid") int Districtid);
////@GET("home3/showall3/{Mobilenumber}/{luanguageid}/0/{stateid}/{Districtid}/{tname}/{vname}")
////    Observable<Alldataformhome> getnewAllHomeData(@Path("Mobilenumber") String Mobilenumber,
////                                                  @Path("luanguageid") String luanguageid,
////                                                  @Path("stateid") int stateid,
////                                                  @Path("Districtid") int Districtid,
////                                                  @Path("tname")String tname,
////                                                  @Path("vname")String vname);
////
////    @GET("getLaboratoryDetails/{lat}/{lon}")
////    Observable<SoiltestingModelclass> getSoiltesting(@Path("lat") double lat, @Path("lon") double lon);
////
////    @GET("news3/getCommodityNews/")
////    Observable<List<ComoNewsModel>> getCommodityNews();
////
////    @GET("news3/getNewsType/{languageId}")
////    Observable<NewsDasboard> getnewsDasboard(@Path("languageId") String lang);
////
////    @GET("news3/getnewsDetails/{mobile}/{langaug}/{type}")
////    Observable<Alldataformhome> getNewscotegary(@Path("mobile") String mobile, @Path("langaug") String langa, @Path("type") String type);
////
////    @GET("getTutorialImages")
////    Observable<Tutorialgetset> getTutorialImage();
////
////    @GET("userExist/{phoneNo}")
////    Observable<thiefmodel> thiefapi(@Path("phoneNo") String phoneNo);
////
////    @GET("registration3/terms/en")
////    Observable<termcondition> getTermcondition();
////
////    @POST("activeUser")
////    Observable<ActiveUser> activeuser(@Body ActiveUser activeUser);
////
////    @POST("gateWay/userNewSubscription/{key}/{Phone}")
////    Observable<UserSucerpitionDetail> userNewSubscription(@Path("key") String key, @Path("Phone") String Phone);
////
////    @GET("mandi3/getMandiFullDetails/{Phone}")
////    Observable<NewMandiPojo> getmandipricetext(@Path("Phone") String Phone);
////
////    @GET("news3/getMarketReport")
////    Observable<List<MarketReportModelclass>> getMarketReport();
////
////    @GET("news3/getReport/{cropName}/{reportType}")
////    Observable<List<PdfModelclass>> getMarketReportpdf(@Path("cropName") String cropName, @Path("reportType") String reportType);
////
////
////    @GET("buyerseller/getbuyerposts/{mobile}/{catid}/{subcatid}/{itemId}")
////    Observable<ArrayList<BuyerPageModel>> Getbuyerposts(@Path("mobile") String mobile, @Path("catid") int catid,
////                                                        @Path("subcatid") int subcatid, @Path("itemId") int itemId);
////
////    @GET("buyerseller2/isBuyerRegistration/{mobile}")
////    Observable<CheckuserRegistation> Checkuserregistation(@Path("mobile") String mobile);
////
////    @POST("buyerseller2/buyerRegistration")
////    Observable<Response<Void>> buyerRegistration(@Body BuyerRegistation buyerRegistation);
////
////    @Multipart
////    @POST("buyerseller2/buyerShopImageUpload")
////    Observable<BaseResponse> buyerShopImageUpload(@Part MultipartBody.Part image);
////
////    @POST("buyerseller2/savesellerpost")
////    Observable<Response<Void>> UploadSavesellerpost(@Body Sallerpostitem buyerRegistation);
////
////    @Multipart
////    @POST("buyerseller/sellerimagepost")
////    Observable<BaseResponse> SeallerImageUpload(@Part MultipartBody.Part image);
////
////
////    @POST("insurence/addInsurenceDetails")
////    Observable<BaseResponse> addInsurenceDetails(@Body InsorenceModelClass insorenceModelClass);
////
////    @POST("gateWay/updateSubscriptionStatus")
////    Observable<Response<Void>> AstroPaymentDetail(@Body Astropaymentdetail astropaymentdetail);
////
////    @GET
////    Observable<ResponseBody> downloadFileWithDynamicUrl(@Url String fileUrl);
////
////    @Multipart
////    @POST("insurence/uploadAdharImages")
////    Observable<Imageposteinsorance>Insoreanceimageresponce (@Part MultipartBody.Part image,@PartMap Map<String, RequestBody> partMap);
//
//
//}
