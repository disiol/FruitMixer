package com.fruitmixer.manedger;


public interface PreferencesManager {

    String getURL();

    void setURL(String token);

    boolean getMyFirstTime();

    void setMyFirstTime(boolean appsFlyerUID);

}
