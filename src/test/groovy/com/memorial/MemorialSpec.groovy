package com.memorial

import com.sun.jmx.snmp.Timestamp
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import org.junit.Test
import org.spockframework.compiler.model.Spec
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Memorial)
class MemorialSpec extends Specification {

    def setup() {
        //mockForConstraintsTests(Memorial)

    }

    def cleanup() {
    }

    @Test
    void "Test name cannot be empty on memorial object"() {
        given:
        Memorial memorial = new Memorial(memorialName: "alpha",
                memorialCreateUser: "beta", memorialUpdateUser: "beta", memorialLocation: "address", memorialActive: true,
                memorialCreateTimestamp: new Timestamp(), memorrialUpdateTimestamp: new Timestamp())

        when: "memorial name is empty"
        memorial.validate()

        then: ""
        assert !memorial.hasErrors()

        when: ""
        memorial.memorialName = null
        memorial.validate()

        then: "validation should not fail if all required fileds are populated"
        memorial.hasErrors()
        memorial.errors.getErrorCount()==1
        assert memorial.errors.getFieldError("memorialName") != null

//        when: "memorial "
//        memorial.memorialName = "memorialAlpah"
//
//        then: "when memorial "
//        memorial.validate()
    }

    void "Test name cannot"() {

    }
}
