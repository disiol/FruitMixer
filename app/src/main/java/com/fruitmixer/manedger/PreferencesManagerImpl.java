package com.fruitmixer.manedger;

import android.content.Context;
import android.content.SharedPreferences;


public class PreferencesManagerImpl implements PreferencesManager {

    private static final String PREFERENCES = "preferences";
    private static final String URL = "URL";
    private static final String APPS_FLYER_UID = "AppsFlyerUID";
    public static final String MY_FIRST_TIME = "my_first_time";


    private SharedPreferences preferences;

    public PreferencesManagerImpl(Context context) {
        this.preferences = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
    }

    @Override
    public String getURL() {
        return preferences.getString(URL, null);
    }

    @Override
    public void setURL(String URL) {
        preferences.edit().putString(PreferencesManagerImpl.URL, URL).apply();
    }

    @Override
    public boolean getMyFirstTime() {
        return preferences.getBoolean(PreferencesManagerImpl.MY_FIRST_TIME, true);
    }

    @Override
    public void setMyFirstTime(boolean appsFlyerUID) {
        preferences.edit().putBoolean(PreferencesManagerImpl.MY_FIRST_TIME, appsFlyerUID).apply();
    }


}
