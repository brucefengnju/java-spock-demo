package org.brucefeng.spockdemo;

import org.brucefeng.spockdemo.bean.User;

public class UserInfoServiceImpl implements UserService {
    private BasicInfoService basicInfoService;

    public void setBasicInfoService(BasicInfoService basicInfoService) {
        this.basicInfoService = basicInfoService;
    }

    public User getUser(int userId) {
        if(userId == 1){
            User user = new User();
            user.setGender("1");
            user.setMobile(this.basicInfoService.getMobile(userId));
            user.setName("1test");
            user.setUserId(1);
            return user;
        }else if(userId == 2){
            User user = new User();
            user.setGender("2");
            user.setMobile(this.basicInfoService.getMobile(userId));
            user.setName("2test");
            user.setUserId(2);
            return user;
        }
        return null;
    }


}
