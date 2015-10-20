package com.memorial

import com.sun.jmx.snmp.Timestamp
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Memorial)
class MemorialSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Test name cannot be empty on memorial object"() {
        when: "memorial name is empty"
        Memorial memorial = new Memorial(memorialName: "alpha",
                memorialCreateUser: "beta", memorialUpdateUser: "beta", memorialLocation: "address", memorialActive: true,
                memorialCreateTimestamp: new Timestamp(), memorrialUpdateTimestamp: new Date())

        then: "validation should not fail if all required fileds are populated"
        memorial.validate()

//        when: "memorial "
//        memorial.memorialName = "memorialAlpah"
//
//        then: "when memorial "
//        memorial.validate()
    }

    void "Test name cannot"() {

    }
}
