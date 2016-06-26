package org.brucefeng.spockdemo

import spock.lang.Specification

class BasicInfoServiceImplTest extends Specification {
    def toTestObj = new BasicInfoServiceImpl();

    def "GetMobile"() {
        when:

        String mobile = toTestObj.getMobile(1);
        then:

        !mobile.isEmpty();
        mobile.equals("11111111111")
    }
    def "getMobileExpect"(){
        expect:
        toTestObj.getMobile(2).equals("22222222222")
    }

    def "getMobileAssert"(){
        when:
        String mobile = toTestObj.getMobile(4);
        then:
        assert mobile == null;

        when:
        toTestObj.getMobile(3);
        then:
        thrown(IllegalArgumentException)
    }

    def "getMobileWhere"(){
        expect:
        toTestObj.getMobile(userId) == expeted

        where:
        userId||expeted
        1||"11111111111"
        2||"22222222222"
        4||null
    }

}
