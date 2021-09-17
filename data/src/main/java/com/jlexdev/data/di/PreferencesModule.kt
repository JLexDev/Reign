package com.jlexdev.data.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.jlexdev.data.preferences.SecurePreferences
import com.jlexdev.data.preferences.SecurePreferencesImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

val preferencesModule = module {
    single(named("securePrefs")) { provideSecurePreferences(androidApplication()) }
    single<SecurePreferences> { SecurePreferencesImpl(get(named("securePrefs"))) }
}

/* Secure */
private const val SECURE_PREFS_FILE_KEY = "com.jlexdev.secure_preferences"

const val PREF_KEY_ACCESS_TOKEN = "key_user_access_token"
const val PREF_KEY_USER_NAME = "key_user_name"
const val PREF_KEY_FCM_TOKEN = "key_fcm_token"
const val PREF_KEY_USER_FIREBASE_ID = "key_user_firebase_id"

private fun provideSecurePreferences(app: Application): SharedPreferences =
    app.getSharedPreferences(SECURE_PREFS_FILE_KEY, Context.MODE_PRIVATE)
