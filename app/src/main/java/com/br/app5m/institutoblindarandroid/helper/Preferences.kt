package com.br.app5m.institutoblindarandroid.helper

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Preferences @SuppressLint("CommitPrefEdits") constructor(context: Context) {
    private val preferences: SharedPreferences
    private val editor: SharedPreferences.Editor

    operator fun set(key: String?, value: String?) {
        editor.putString(key, value)
        editor.commit()
    }
   /* fun setListJogadorData(list: List<Jogador?>?) {
        val gson = Gson()
        val json = gson.toJson(list)
        set("arrayGoleadores", json)
    }*/
    fun set_messageSelf(str: String) {
        val gson = Gson()
        val json = gson.toJson(str)
        set("messageSelf", json)
    }
    fun clear_messageSelf() {
        editor?.remove("messageSelf")
        editor!!.commit()
    }
    fun get_messageSelf(): String? {
        val srt: String
        val gson = Gson()
        val data = preferences!!.getString("messageSelf", "")
        return if (data != null && data.isNotEmpty()) {
            srt = gson.fromJson(data, String::class.java)
            srt
        } else null
    }

  /*  fun set_camp(liga: Liga?) {
        val data = Gson().toJson(liga)
        editor!!.putString("camp_new", data)
        editor!!.commit()
    }


    fun get_camp(): Liga? {
        val liga: Liga
        val gson = Gson()
        val data = preferences!!.getString("camp_new", "")
        return if (data != null && data.isNotEmpty()) {
            liga = gson.fromJson(data, Liga::class.java)
            liga
        } else null
    }
    fun clear_camp() {
        editor?.remove("camp_new")
        editor!!.commit()
    }

    fun getListJogadorData(): List<Jogador?>? {
        var arrayItems: List<Jogador?>? = null
        val serializedObject = preferences!!.getString("arrayGoleadores", "")
        if (serializedObject != null) {
            val gson = Gson()
            val type = object : TypeToken<List<Jogador?>?>() {}.type
            arrayItems = gson.fromJson<List<Jogador?>>(serializedObject, type)
        }
        return arrayItems
    }
    fun clearListJogadorData() {
        editor?.remove("arrayGoleadores")
        editor!!.commit()
    }
    fun setUserLocation(location: LocationUser?) {
        val dados = Gson().toJson(location)
        editor!!.putString("location", dados)
        editor!!.commit()
    }

    fun setUserLocationAux(num: String) {
        editor!!.putString("locationAux", num)
        editor!!.commit()
    }
    fun getUserLocationAux(): String? {
        val data = preferences.getString("locationAux", "")
        return data
    }

    fun clearUserLocationAux() {
        editor.remove("locationAux").commit()
    }
    fun setIntroAux(num: String) {
        editor!!.putString("IntroAux", num)
        editor!!.commit()
    }
    fun getIntroAux(): String? {
        val data = preferences.getString("IntroAux", "")
        return data
    }
    fun clearIntroAux() {
        editor.remove("IntroAux").commit()
    }
    fun clearUserLocation(){
        editor?.remove("location")
        editor!!.commit()
    }
    fun getUserLocation(): LocationUser? {
        val location: LocationUser
        val gson = Gson()
        val data = preferences!!.getString("location", "")
        return if (data!!.isNotEmpty()) {
            location = gson.fromJson(data, LocationUser::class.java)
            location
        } else null
    }
    var userData: User
        get() {
            val user: User
            val gson = Gson()
            val data = preferences.getString("getData", "")
            return if (!data!!.isEmpty()) {
                user = gson.fromJson(data, User::class.java)
                user
            } else User()
        }
        set(user) {
            val dados = Gson().toJson(user)
            editor.putString("getData", dados)
            editor.commit()
        }
    var timeData: Time
        get() {
            val time: Time
            val gson = Gson()
            val data = preferences.getString("getDataTime", "")
            return if (!data!!.isEmpty()) {
                time = gson.fromJson(data, Time::class.java)
                time
            } else Time()
        }
        set(time) {
            val dados = Gson().toJson(time)
            editor.putString("getDataTime", dados)
            editor.commit()
        }

    //Recupera a escalação por objeto
    fun setEscalacao(escalacao: Escalacoes?, id_time: String) {
        val dados = Gson().toJson(escalacao)
        editor.putString("escalacao$id_time", dados)
        editor.commit()
    }

    fun getEscalacao(id_time: String): Escalacoes? {
        val escalacao: Escalacoes
        val gson = Gson()
        val data = preferences.getString("escalacao$id_time", "")
        return if (!data!!.isEmpty()) {
            escalacao = gson.fromJson(data, Escalacoes::class.java)
            escalacao
        } else null
    }

    fun clearEscala(id_time: String) {
        editor.remove("escalacao$id_time").commit()
    }

    fun clearUserData() {
        editor.remove("getData").commit()
        editor.remove("login").commit()
        editor.remove("token").commit()
        editor.remove("pastas").commit()
    }

    var login: Boolean
        get() = preferences.getBoolean("login", false)
        set(login) {
            editor.putBoolean("login", login)
            editor.commit()
        }
    var tenhoTimeEscalado: Boolean
        get() = preferences.getBoolean("tenhoTimeEscalado", false)
        set(tenhoTimeEscalado) {
            editor.putBoolean("tenhoTimeEscalado", tenhoTimeEscalado)
            editor.commit()
        }
    fun clearTenhoTimeEscalado() {
        editor.remove("tenhoTimeEscalado").commit()

    }
    //key == id_time
    fun setEscalado(key: String?, valido: Boolean) {
        editor.putBoolean(key, valido)
        editor.commit()
    }

    //key == id_time
    //Recupera a escalação por boolean
    fun getEscalado(key: String?): Boolean {
        return preferences.getBoolean(key, false)
    }

    fun setCodRodada(cod: String?, id_time: String) {
        editor.putString("rodada$id_time", cod)
        editor.commit()
    }

    fun getCodRodada(id_time: String): String? {
        return preferences.getString("rodada$id_time", "")
    }

    val type: String?
        get() = preferences.getString("type", "")

    fun save_fcm(fcm: String?) {
        editor.putString("fcm", fcm)
        editor.commit()
    }

    fun fcm(): String? {
        return preferences.getString("fcm", "")
    }

    fun save_first_user(id: String?) {
        editor.putString("user", id)
        editor.commit()
    }

    fun first_user(): String? {
        return preferences.getString("user", "0")
    }

    fun getInstanceTokenFcm(): String {
        return preferences!!.getString("token", "")!!
    }
    fun saveInstanceTokenFcm(key: String?, value: String) {
        editor?.putString(key, value)
        editor!!.commit()
    }*/

    init {
        preferences = context.getSharedPreferences("note.preference", 0)
        editor = preferences.edit()
    }
}