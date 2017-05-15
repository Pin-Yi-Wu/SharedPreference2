package com.example.mina.sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.HashMap;

public class SessionManager {
    SharedPreferences pref;
    Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "Vikas";
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";

    public SessionManager(Context context) {
        this._context = context;
        this.pref = this._context.getSharedPreferences("Vikas", this.PRIVATE_MODE);
        this.editor = this.pref.edit();
    }

    public void createLoginSession(String name, String email) {
        this.editor.putBoolean("IsLoggedIn", true);
        this.editor.putString("name", name);
        this.editor.putString("email", email);
        this.editor.commit();
    }

    public void checkLogin() {
        if(!this.isLoggedIn()) {
            Intent i = new Intent(this._context, LoginActivity.class);
            i.addFlags(67108864);
            i.setFlags(268435456);
            this._context.startActivity(i);
        }

    }

    public HashMap<String, String> getUserDetails() {
        HashMap user = new HashMap();
        user.put("name", this.pref.getString("name", (String)null));
        user.put("email", this.pref.getString("email", (String)null));
        return user;
    }

    public void logoutUser() {
        this.editor.clear();
        this.editor.commit();
        Intent i = new Intent(this._context, LoginActivity.class);
        i.addFlags(67108864);
        i.setFlags(268435456);
        this._context.startActivity(i);
    }

    public boolean isLoggedIn() {
        return this.pref.getBoolean("IsLoggedIn", false);
    }
}
