package org.brucefeng.spockdemo

import spock.lang.Specification

class DemoTest extends Specification {
    def sum = new Demo();
    def "Sum"() {
        expect:
        sum.sum(1,1) == 2
    }

    def "sumtest"(){
        expect:
        sum.sum(1,2) == 3
    }
}
