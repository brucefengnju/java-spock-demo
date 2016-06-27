package org.brucefeng.spockdemo

import org.brucefeng.spockdemo.bean.User
import spock.lang.Specification

class UserInfoServiceImplMockTest extends Specification {
    UserInfoServiceImpl toBeTest = new UserInfoServiceImpl();
    BasicInfoService mockBasic = Mock();

    def setup(){
        toBeTest.setBasicInfoService(mockBasic);
    }
    def "getUserWithBasicMock"() {
        setup:
        mockBasic.getMobile(1)>>"23234355"
        when:
        User user= toBeTest.getUser(1);
        then:
        user != null
        user.getMobile() != null
        user.getMobile().equals("23234355")

    }
}
