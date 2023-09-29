package com.lulu.teoremus.utils

import android.content.Context
import com.lulu.teoremus.model.User

object SharedPreferencesUtil {

    fun savePreferences(context: Context, user: User){
        val sharedPreferences = context.getSharedPreferences(SHARED_USER_KEY, Context.MODE_PRIVATE)
        val edit = sharedPreferences.edit()
        edit.putInt("moduloI", user.moduloI!!)
        edit.putInt( "moduloII", user.moduloII!!)
        edit.putInt( "moduloIII", user.moduloIII!!)
        edit.putInt( "moduloIV", user.moduloIV!!)
        edit.putInt( "total", user.total!!)
        edit.apply()
    }
}