package com.bkc.myeducationapp.utility;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by startxlabs-2 on 5/8/17.
 */

public class SharedPrefUtils {

    private static SharedPrefUtils sharedPrefUtils;

    private SharedPrefUtils() {

    }

    public static SharedPrefUtils getInstance() {
        if (sharedPrefUtils == null) {
            sharedPrefUtils = new SharedPrefUtils();
        }
        return sharedPrefUtils;
    }

    public static final String SELECTED_LANGUAGE = "Locale.Helper.Selected.Language";
    public static final String USER_DATA = "user_data";
    public static final String TUTORIAL = "tutorial_action";
    public static final String TUTORIAL_KEY = "tutorial_status";
    public static final String Validation = "Mandiivalidation";
    public static final String Validation_key = "Mandi";


    public void setAppLanguage(Context context, String key,
                               String value) {
        SharedPreferences appInstallInfoSharedPref = context
                .getSharedPreferences(SELECTED_LANGUAGE, Context.MODE_PRIVATE);
        SharedPreferences.Editor appInstallInfoEditor = appInstallInfoSharedPref.edit();
        appInstallInfoEditor.putString(key, value);
        appInstallInfoEditor.apply();
    }

    public String getAppLanguage(Context context, String key) {
        SharedPreferences userAccountPreference = context.getSharedPreferences(
                SELECTED_LANGUAGE, Context.MODE_PRIVATE);
        return userAccountPreference.getString(key, null);
    }

    public void clearAppLanguage(Context context) {
        SharedPreferences appInstallInfoSharedPref = context.getSharedPreferences(SELECTED_LANGUAGE,
                Context.MODE_PRIVATE);
        appInstallInfoSharedPref.edit().clear().apply();

    }

    public void setUser(Context context, String key,
                        String value) {
        SharedPreferences appInstallInfoSharedPref = context
                .getSharedPreferences(USER_DATA, Context.MODE_PRIVATE);
        SharedPreferences.Editor appInstallInfoEditor = appInstallInfoSharedPref.edit();
        appInstallInfoEditor.putString(key, value);
        appInstallInfoEditor.apply();
    }

    public String getUser(Context context, String key) {
        SharedPreferences userAccountPreference = context.getSharedPreferences(
                USER_DATA, Context.MODE_PRIVATE);
        return userAccountPreference.getString(key, null);
    }

    public static void clearUser(Context context) {
        SharedPreferences appInstallInfoSharedPref = context.getSharedPreferences(USER_DATA, Context.MODE_PRIVATE);
        appInstallInfoSharedPref.edit().clear().apply();

    }

    public static int setapptutorial(Context context, int status) {
        SharedPreferences appInstallInfoSharedPref = context
                .getSharedPreferences(TUTORIAL, Context.MODE_PRIVATE);
        SharedPreferences.Editor tutorialEditor = appInstallInfoSharedPref.edit();
        tutorialEditor.putInt(TUTORIAL_KEY, status);
        tutorialEditor.apply();
        return status;
    }

    public static int getapptutorial(Context context) {
        SharedPreferences tutorialPreference = context.getSharedPreferences(
                TUTORIAL, Context.MODE_PRIVATE);
        return tutorialPreference.getInt(TUTORIAL_KEY, 0);

    } public static String setMandiValidation(Context context, String status) {
        SharedPreferences appInstallInfoSharedPref = context
                .getSharedPreferences(Validation, Context.MODE_PRIVATE);
        SharedPreferences.Editor tutorialEditor = appInstallInfoSharedPref.edit();
        tutorialEditor.putString(Validation_key, status);
        tutorialEditor.apply();
        return status;
    }

    public static String getMandiValidation(Context context) {
        SharedPreferences tutorialPreference = context.getSharedPreferences(
                Validation, Context.MODE_PRIVATE);
        return tutorialPreference.getString(Validation_key,null);

    }
}
