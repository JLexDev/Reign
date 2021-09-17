package com.jlexdev.data.preferences

import android.content.SharedPreferences
import com.jlexdev.data.di.PREF_KEY_ACCESS_TOKEN
import com.jlexdev.data.di.PREF_KEY_USER_FIREBASE_ID
import com.jlexdev.data.di.PREF_KEY_USER_NAME

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

class SecurePreferencesImpl(private val prefs : SharedPreferences) : SecurePreferences {

    override fun saveLogInInfo(token: String, name: String, firebase_id: String) {
        prefs.edit().putString(PREF_KEY_ACCESS_TOKEN, "Bearer $token").apply()
        prefs.edit().putString(PREF_KEY_USER_NAME, name).apply()
        prefs.edit().putString(PREF_KEY_USER_FIREBASE_ID, firebase_id).apply()
    }

    override fun getFirebaseId() = prefs.getString(PREF_KEY_USER_FIREBASE_ID, "")?:""

    override fun getAccessToken() = prefs.getString(PREF_KEY_ACCESS_TOKEN, "")?:""

    override fun getClientName() = prefs.getString(PREF_KEY_USER_NAME, "")?:""

    override fun logOut() = prefs.edit().clear().apply()

}