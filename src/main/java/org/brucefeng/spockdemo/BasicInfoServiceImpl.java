package org.brucefeng.spockdemo;

public class BasicInfoServiceImpl implements BasicInfoService {

    public String getMobile(int userId) {
        if(userId == 1){
            return "11111111111";
        }else if(userId ==2 ){
            return "22222222222";
        }
        return null;
    }
}
