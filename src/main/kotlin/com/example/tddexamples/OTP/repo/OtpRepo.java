package com.example.tddexamples.OTP.repo;

import com.example.tddexamples.OTP.model.OtpModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@EnableMongoRepositories
public interface OtpRepo extends MongoRepository<OtpModel,String> {


    OtpModel findByOtpId(String otpId);

    List<OtpModel> getAllOtps();

}
