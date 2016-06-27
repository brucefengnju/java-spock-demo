package org.brucefeng.spockdemo.spring

import org.brucefeng.spockdemo.UserService
import org.brucefeng.spockdemo.bean.User
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.annotation.Resource

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:/config/appcontext-*"})
@ContextConfiguration(locations = 'classpath*:/config/appcontext-*')
class UserServiceSpockTestWithSpring extends Specification{
    @Resource
    UserService userService;

    def "getUserWithSpring" (){
        when:
        User user = userService.getUser(1)
        then:
        user != null
        user.getMobile().equals("11111111111")
    }


}
