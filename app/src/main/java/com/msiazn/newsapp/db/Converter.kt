package com.msiazn.newsapp.db

import androidx.room.TypeConverter
import com.msiazn.newsapp.model.Source

class Converter {
    @TypeConverter
    fun fromSource(source:Source):String{
        return source.name
    }
    @TypeConverter
    fun toSource(name:String):Source{
        return Source(name,name)
    }
}