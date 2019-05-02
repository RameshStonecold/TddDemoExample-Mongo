package com.example.tddexamples.OTP.service;

import com.example.tddexamples.OTP.model.OtpModel;
import com.example.tddexamples.OTP.model.Status;
import com.example.tddexamples.OTP.repo.OtpRepo;
import io.vavr.control.Either;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Service
public class OtpImpl implements IOtp {

    private OtpRepo otpRepo;
    public OtpImpl(OtpRepo otpRepo){
        this.otpRepo=otpRepo;
    }


    @Override
    public String generateOtp(OtpModel otpModel) {
        RandomNumber randomNumber = new RandomNumber();
       String otp = randomNumber.generateRandomString();
      otpModel.setOtp(otp);
      otpRepo.save(otpModel);
        return otp;
    }

    @Override
    public Either<Exception,String> verifyOtp(String otp,List<OtpModel> otpModelList) {

       List<OtpModel> allOtps = otpRepo.getAllOtps();


    List<OtpModel> dbOtpsWithActiveStatus = allOtps.stream().
            filter(x->x.getStatus().compareTo(Status.ACTIVE)==0).collect(Collectors.toList());

    dbOtpsWithActiveStatus.stream().
            filter(x-> LocalDateTime.now().isBefore(x.getValidateTime()) || x.equals(x.getValidateTime()));




        return null;
    }


}
