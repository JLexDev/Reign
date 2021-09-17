package com.jlexdev.data.preferences

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

interface SecurePreferences {
    fun saveLogInInfo(token: String, name: String, firebase_id: String)
    fun getAccessToken() : String
    fun getClientName(): String
    fun getFirebaseId() : String
    /**
     * Clear all values from pref file.
     */
    fun logOut()
}