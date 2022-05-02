package com.example.gumtreetechtest

import com.example.gumtreetechtest.ui.InputValidator
import com.example.gumtreetechtest.ui.ValidationType
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class InputValidatorTest{

    private val inputValidator = InputValidator()

    @Test
    fun yearLessThanFourChars_returnsFalse(){
        val expected = false
        val actual = inputValidator.validate("1", ValidationType.YEAR)

        assert(expected==actual)
    }

    @Test
    fun threeChars_returnsFalse(){
        val expected = false
        val actual = inputValidator.validate("200", ValidationType.YEAR)

        assert(expected==actual)
    }

    @Test
    fun validDate_returnsTrue(){
        val expected = true
        val actual = inputValidator.validate("2000", ValidationType.YEAR)

        assert(expected==actual)
    }

    @Test
    fun dateBefore1900_returnsFalse(){
        val expected = false
        val actual = inputValidator.validate("1899", ValidationType.YEAR)

        assert(expected==actual)
    }
    @Test
    fun dateInFuture_returnsFalse(){
        val expected = false
        val actual = inputValidator.validate("2023", ValidationType.YEAR)

        assert(expected==actual)
    }

    @Test
    fun emptyMake_returnsFalse(){
        val expected = false
        val actual = inputValidator.validate("", ValidationType.MAKE)

        assert(expected==actual)
    }

    @Test
    fun emptyModel_returnsFalse(){
        val expected = false
        val actual = inputValidator.validate("", ValidationType.MODEL)

        assert(expected==actual)
    }
}