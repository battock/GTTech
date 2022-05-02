package com.example.gumtreetechtest.ui

import android.util.Log
import com.example.gumtreetechtest.ui.screens.SEARCH_SECTION_LOGGING_TAG
import com.example.gumtreetechtest.utils.logging
import java.lang.NumberFormatException

/*
Just a basic try catch but in a real application this would be more considered
 */
class InputValidator {
    var validYear: Boolean = false
        private set
    var validMake: Boolean = false
        private set
    var validModel: Boolean = false
        private set
    var allInputsValid: Boolean = false
        private set

    fun validate(input: String, validationType: ValidationType): Boolean {
        var isValid = true
        when (validationType) {
            ValidationType.YEAR -> {
                try {
                    if (input.length != 4) {
                        isValid = false
                    }
                    val intVal = input.toInt()
                    if (intVal < 1900 || intVal > 2022) {
                        isValid = false
                    }
                } catch (ex: NumberFormatException) {
                    Log.e(SEARCH_SECTION_LOGGING_TAG, "year format invalid failed with ex $ex")
                    isValid = false
                }
                validYear = isValid
            }
            ValidationType.MAKE -> {
                isValid = input.isNotEmpty()
                validMake = isValid
            }
            ValidationType.MODEL -> {
                isValid = input.isNotEmpty()
                validModel = isValid
            }
        }
        allInputsValid = validModel && validMake && validYear
        logging(INPUTVALIDATOR_LOGGING_TAG, "input is valid : $isValid")
        return isValid
    }
    companion object inputValidatorTag{
        private const val INPUTVALIDATOR_LOGGING_TAG ="InputValidator"
    }
}

enum class ValidationType {
    YEAR,
    MAKE,
    MODEL
}