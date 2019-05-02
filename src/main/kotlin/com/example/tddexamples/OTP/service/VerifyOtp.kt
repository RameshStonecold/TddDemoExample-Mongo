package com.example.tddexamples.OTP.service

import com.example.tddexamples.OTP.model.OtpModel
import com.example.tddexamples.OTP.model.Status
import kotlin.streams.toList

class VerifyOtp {

    fun verify(otp:String, list:List<OtpModel>){

        val otplist =list.stream().
                filter{x->x.status.compareTo(Status.ACTIVE)==0}.toList()




    }

}