package com.harloomdev.camerabooking.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.harloomdev.camerabooking.Http.conf.Server;

import androidx.preference.PreferenceManager;

public class Preferences {
    private static String keyID = "id_ktp";
    private static String keyAPI = "key_api";
    private static String flagLogin =  "login_status";

    private  SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor editor;
    private  Context context;

    public Preferences(Context context) {
        this.mSharedPreferences = context.getSharedPreferences(Server.fileKey,Context.MODE_PRIVATE);
        this.editor = mSharedPreferences.edit();
        this.context = context;
    }

    public void saveIdKTP (String id){
        editor.putString(keyID,id);
        editor.apply();

    }
    public void savekeyAPI (String api){
        editor.putString(keyAPI,api);
        editor.apply();

    }

    public  void saveStatus(Boolean aBoolean){
        editor.putBoolean(flagLogin,aBoolean);
        editor.apply();
    }

    public String getIDKTP(){
        return mSharedPreferences.getString(keyID,"");
    }
    public String getKeyAPI(){
        return mSharedPreferences.getString(keyAPI,"");
    }
    public  Boolean getStatus(){
        return  mSharedPreferences.getBoolean(flagLogin,false);
    }


}
