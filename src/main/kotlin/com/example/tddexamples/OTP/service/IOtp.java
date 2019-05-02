package com.example.tddexamples.OTP.service;

import com.example.tddexamples.OTP.model.OtpModel;
import io.vavr.control.Either;

import java.util.List;

public interface IOtp {


    String generateOtp(OtpModel otpModel);

    Either<Exception, String> verifyOtp(String otp,List<OtpModel> otpModelList);




}
