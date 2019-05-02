/*
package com.example.tddexamples.OTP.service;

import java.util.Random;

public class RandomNumber {

    private char[] CHAR_LIST ={'1','2','3','4','5','6','7','8','9','0'};

    private Integer RANDOM_STRING_LENGTH=6;

    private int length =6;

     public String getRandomString(){

         int randomNum = generateNum();

         StringBuffer randStr = new StringBuffer() ;

         for (int i=0; i<=RANDOM_STRING_LENGTH; i++){

             randStr.append(CHAR_LIST[randomNum]);

         }

         return randStr.toString();

}


    private  int generateNum() {
        String numbers = "1234567890";
        Random random = new Random();
        char[] otp = new char[RANDOM_STRING_LENGTH];

        for(int i = 0; i< RANDOM_STRING_LENGTH ; i++) {
            otp[i] = numbers.charAt(random.nextInt(numbers.length()));
        }

      String otpnew = String.valueOf(otp);

        int num = Integer.parseInt(otpnew);

        return num;
    }



}
*/
