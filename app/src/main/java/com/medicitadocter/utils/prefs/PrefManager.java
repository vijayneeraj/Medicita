package com.medicitadocter.utils.prefs;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * This class used to access {@link SharedPreferences} functionality
 *
 * @author Rahul Singh Faujdar
 * @version 1.0
 */
public class PrefManager {

    private Context mCtx;
    private static final String PREF_NAME = "pref_medicita";
    private SharedPreferences mSharedPref;

    public PrefManager(Context mCtx) {
        this.mCtx = mCtx;
        mSharedPref = mCtx.getApplicationContext().getSharedPreferences(PREF_NAME, 0);
    }

    public void setStringPref(String key, String value) {
        mSharedPref.edit().putString(key, value).apply();
    }

    public void setBoolPref(String key, boolean value) {
        mSharedPref.edit().putBoolean(key, value).apply();
    }

    public void setIntPref(String key, int value) {
        mSharedPref.edit().putInt(key, value).apply();
    }

    public void setFloatPref(String key, float value) {
        mSharedPref.edit().putFloat(key, value).apply();
    }

    public String getStringPref(String key) {
        return mSharedPref.getString(key, null);
    }

    public boolean getBoolPref(String key) {
        return mSharedPref.getBoolean(key, false);
    }

    public int getIntPref(String key) {
        return mSharedPref.getInt(key, 0);
    }

    public float getFloatPref(String key) {
        return mSharedPref.getFloat(key, 0.0f);
    }

}
