package com.example.tddexamples

import org.junit.Assert
import org.junit.Test
import java.util.*

class RandomNumber {

    private val CHAR_LIST = "1234567890"
    private val RANDOM_STRING_LENGTH = 6


    fun generateRandomString(): String {

        val randStr = StringBuffer()
        for (i in 0 until RANDOM_STRING_LENGTH) {
            val number = getRandomNumber()
            val ch = CHAR_LIST[number]
            randStr.append(ch)
        }
        return randStr.toString()
    }

    /**
     * This method generates random numbers
     * @return int
     */
    private fun getRandomNumber(): Int {
        var randomInt = 0
        val randomGenerator = Random()
        randomInt = randomGenerator.nextInt(CHAR_LIST.length)
        return if (randomInt - 1 == -1) {
            randomInt
        } else {
            randomInt - 1
        }

    }

    @Test
    fun otpTest(){
        var otp = generateRandomString()

        Assert.assertTrue(otp.length==6)
    }

}