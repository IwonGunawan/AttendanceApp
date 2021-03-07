package com.iwon.attendance;

import android.content.Context;
import android.content.SharedPreferences;

class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context mContext;

    // shared pref mode
    int PRIVATE_MODE = 0;

    private static final String PREF_MANAGER_NAME = "attendance-app";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    PrefManager(Context context){
        this.mContext = context;
        this.pref = context.getSharedPreferences(PREF_MANAGER_NAME, PRIVATE_MODE);
        this.editor = this.pref.edit();
    }

    public void setFirstTimeLaunch(Boolean isFirstTime){
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch(){
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

}
