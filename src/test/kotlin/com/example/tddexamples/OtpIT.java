package com.example.tddexamples;

import com.example.tddexamples.OTP.model.OtpModel;
import com.example.tddexamples.OTP.model.Status;
import com.example.tddexamples.OTP.service.IOtp;
import com.example.tddexamples.OTP.service.OtpImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OtpIT {


    @Autowired
    IOtp otp;

    @Test
    public void insertOtp(){


        OtpModel otpModel = new OtpModel("122","",LocalDateTime.now(),LocalDateTime.now(),Status.ACTIVE);

       String ot = otp.generateOtp(otpModel);

        Assert.assertTrue(ot.length()==6);

    }
}
