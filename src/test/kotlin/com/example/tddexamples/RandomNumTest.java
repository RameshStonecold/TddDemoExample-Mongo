package com.example.tddexamples;

import com.example.tddexamples.OTP.service.RandomNumber;
import org.junit.Assert;
import org.junit.Test;

public class RandomNumTest {

    @Test
    public  void numTest(){

        RandomNumber randomNumber = new RandomNumber();

       String otp = randomNumber.generateRandomString();

       System.out.println(otp);
        Assert.assertTrue(otp.length()<=6);
    }
}
