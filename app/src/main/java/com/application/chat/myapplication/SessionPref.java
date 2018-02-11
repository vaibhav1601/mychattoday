package com.application.chat.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by vaibhav on 23/1/18.
 */

public class SessionPref
{

    SharedPreferences pref;
    // Editor for Shared preferences
    SharedPreferences.Editor editor;
    // Context
    Context _context;
    // Shared pref mode
    int PRIVATE_MODE = 0;
    public static final String PREF_NAME = "DemoChat";
    public static final String userId ="userId";
    public static final String isUserLoggedIn ="isUserLoggedIn";

    public void clear(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();
    }

    public SessionPref(Context context)
    {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public String getPreference(String prefConst) {
        return pref.getString(prefConst, null);
    }


    public void setPreference(String prefConst, String val){
        editor.putString(prefConst, val);
        editor.commit();
    }


}
