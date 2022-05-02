package com.example.gumtreetechtest.utils

import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CommonFunctionsKtTest{

    @Test
    fun invalidPriceReturnsMessage_whenEmptyPriceString(){
        val actualResult = "".validateStringPrice()
        val expectedResult = INVALID_PRICE_ERROR
        assert(actualResult==expectedResult)
    }

    @Test
    fun invalidPriceReturnsMessage_whenNoPoundSign(){
        val actualResult = "23.23".validateStringPrice()
        val expectedResult = INVALID_PRICE_ERROR
        assert(actualResult==expectedResult)
    }

    @Test
    fun invalidPriceReturnsMessage_whenNoDecimalPoint(){
        val actualResult = "2323".validateStringPrice()
        val expectedResult = INVALID_PRICE_ERROR
        assert(actualResult==expectedResult)
    }

    @Test
    fun riceReturned_whenValidPriceAdded(){
        val validPrice = "£23.23"
        val actualResult = validPrice.validateStringPrice()
        val expectedResult = validPrice
        assert(actualResult==expectedResult)
    }
}
