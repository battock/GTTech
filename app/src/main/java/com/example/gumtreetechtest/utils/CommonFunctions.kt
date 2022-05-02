package com.example.gumtreetechtest.utils

import android.util.Log
import android.util.Log.DEBUG
import android.util.Log.ERROR
import android.util.Log.VERBOSE
import java.lang.NumberFormatException
const val commonFunctionsLoggingTag = "CommonFunctions"

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


fun String.validateStringPrice(): String {
    try{
       val hasPoundPrefix =  this.first()=='£'
       val secondDigitIsNotZero = this[1].toString().toInt()>0
       val decimalNumber = this.substring(1,this.length).toDouble()
       if(decimalNumber> 0.0 && hasPoundPrefix && secondDigitIsNotZero){
           return this
       }
    }
    catch (ex:Exception){
        logging(commonFunctionsLoggingTag, "invalid price returned from api")
        return INVALID_PRICE_ERROR
    }
    return INVALID_PRICE_ERROR
}
const val INVALID_PRICE_ERROR = "no price available"