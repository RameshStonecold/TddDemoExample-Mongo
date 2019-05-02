package com.example.tddexamples.OTP.model;

import io.vavr.control.Either;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class OtpModel
{
    public String getOtpId() {
        return otpId;
    }

    public void setOtpId(String otpId) {
        this.otpId = otpId;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getValidateTime() {
        return validateTime;
    }

    public void setValidateTime(LocalDateTime validateTime) {
        this.validateTime = validateTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private String otpId;
    private String otp;
    private LocalDateTime createdTime;
    private LocalDateTime validateTime ;
    private Status status=Status.ACTIVE;

   public OtpModel(String otpId, String otp, LocalDateTime createdTime, LocalDateTime validateTime, Status status){
        this.otpId =otpId;
        this.otp=otp;
        this.createdTime = createdTime;
        this.validateTime = validateTime;
        this.status=Status.ACTIVE;
    }


    public OtpModel(String otpId, String otp){
        this.otpId =otpId;
        this.otp =otp;
        this.createdTime=LocalDateTime.now();
        this.validateTime =LocalDateTime.now().minusMinutes(15);
        this.status=Status.ACTIVE;
    }


    public Either<Exception,Boolean> validateOtp(){

        Long minutes = ChronoUnit.MINUTES.between(this.createdTime,this.validateTime);

        if (minutes>15){

          return  Either.left(new Exception("OTP Time Out"));
        }

        return Either.right(true);

    }

}
