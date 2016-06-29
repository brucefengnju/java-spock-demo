package org.brucefeng.spockdemo

import org.brucefeng.spockdemo.bean.User
import spock.lang.Specification

class UserInfoServiceImplMockTest extends Specification {
    UserInfoServiceImpl toBeTest = new UserInfoServiceImpl();
    BasicInfoService mockBasic = Mock();
    UserInfoServiceImpl mockedUserService = Mock();
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


    def "getUserWithBasicMockMultiResult"() {
        setup:
        mockBasic = Stub()
        toBeTest.setBasicInfoService(mockBasic)
        mockBasic.getMobile(_)>>>["1mobile","2mobile"] >>"3mobile"

        when:
        User user= toBeTest.getUser(1);
        then:
        user != null
        user.getMobile() != null
        user.getMobile().equals("1mobile")

        when:
        user = toBeTest.getUser(1)
        then:
        user.getMobile().equals("2mobile")

        when:
        user = toBeTest.getUser(1)
        then:
        user.getMobile().equals("3mobile")

    }

    def "getUserWithMockUserService"(){
        User user = new User(
                mobile: "test mobile",
                userId: 222,
                name:"test name",
                gender: 2
        )
        setup:
        mockedUserService.getUser(2) >> user
        when:
        User result = mockedUserService.getUser(2)
        then:
        result != null
        result.mobile.equals(user.mobile)
        result.name.equals(user.name)
        result.gender.equals(user.gender)
    }
}
