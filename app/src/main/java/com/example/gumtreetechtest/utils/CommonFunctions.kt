package com.example.gumtreetechtest.utils

import android.util.Log
import android.util.Log.DEBUG
import android.util.Log.ERROR
import android.util.Log.VERBOSE



fun logging(loggingTag:String,message:String,type:LoggingType = LoggingType.VERBOSE){
    try{
        when(type){
            LoggingType.DEBUG ->{
                Log.d(loggingTag,message)
            }
            LoggingType.ERROR->{
                Log.e(loggingTag,message)
            }
            LoggingType.VERBOSE->{
                Log.v(loggingTag,message)
            }
        }
    }
    catch(ex:Exception){
    }
}

enum class LoggingType {
    DEBUG,
    ERROR,
    VERBOSE
}
