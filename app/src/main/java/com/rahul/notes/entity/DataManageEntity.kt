package com.rahul.notes.entity

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import java.nio.charset.Charset

object DataManageEntity {
    val TAG = "DataManageEntity"
    var data = emptyArray<NotesEntity>()
    var isData = mutableStateOf(false)
    fun loadAssetsFromFile(context : Context){
        Log.d(TAG, "loadAssetsFromFile")
        val inputStream = context.assets.open("MyNotes.json")
        val size : Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<NotesEntity>::class.java)
        isData.value = true
    }
}