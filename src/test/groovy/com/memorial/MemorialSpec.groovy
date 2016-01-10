package com.memorial

import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import org.junit.Test
import org.spockframework.compiler.model.Spec
import spock.lang.Specification

import java.sql.Timestamp

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
    void "Test all constraints on memorial object"() {
        given:
        def now = new Date()
        def timeStamp = now.toTimestamp()
        Memorial memorial = new Memorial(memorialName: "alpha",
                memorialCreateUser: "beta", memorialUpdateUser: "beta", memorialLocation: "address", memorialActive: true,
                memorialCreateTimestamp: timeStamp, memorrialUpdateTimestamp: timeStamp)

        when: "memorial name is empty"
        memorial.validate()

        then: "validation should not fail if all required fileds are populated"
        assert !memorial.hasErrors()

        when: "memorialName is empty"
        memorial.memorialName = null
        memorial.validate()

        then: "validation should fail because memorialName is required field but is empty"
        memorial.hasErrors()
        memorial.errors.getErrorCount()==1
        assert memorial.errors.getFieldError("memorialName") != null

        when: "memorialCreateUser is empty"
        memorial.memorialName = "Alpha"
        memorial.memorialCreateUser = null
        memorial.validate()

        then: "validation should fail because memorialCreateUser is required field but is empty"
        memorial.hasErrors()
        memorial.errors.getErrorCount()==1
        assert memorial.errors.getFieldError("memorialCreateUser") != null

        when: "memorialUpdateUser is empty"
        memorial.memorialCreateUser = "Alpha"
        memorial.memorialUpdateUser = null
        memorial.validate()

        then: "validation should fail because memorialUpdateUser is required field but is empty"
        memorial.hasErrors()
        memorial.errors.getErrorCount()==1
        assert memorial.errors.getFieldError("memorialUpdateUser") != null

        when: "memorialLocation is empty"
        memorial.memorialUpdateUser = "Alpha"
        memorial.memorialLocation = null
        memorial.validate()

        then: "validation should fail because memorialLocation is required field but is empty"
        memorial.hasErrors()
        memorial.errors.getErrorCount()==1
        assert memorial.errors.getFieldError("memorialLocation") != null

        when: "memorialActive is empty"
        memorial.memorialLocation = "Alpha"
        memorial.memorialActive = null
        memorial.validate()

        then: "validation should fail because memorialActive is required field but is empty"
        memorial.hasErrors()
        memorial.errors.getErrorCount()==1
        assert memorial.errors.getFieldError("memorialActive") != null

        when: "memorialCreateTimestamp is empty"
        memorial.memorialActive = "Alpha"
        memorial.memorialCreateTimestamp = null
        memorial.validate()

        then: "validation should fail because memorialCreateTimestamp is required field but is empty"
        memorial.hasErrors()
        memorial.errors.getErrorCount()==1
        assert memorial.errors.getFieldError("memorialCreateTimestamp") != null

        when: "memorrialUpdateTimestamp is empty"
        memorial.memorialCreateTimestamp = timeStamp
        memorial.memorrialUpdateTimestamp = null
        memorial.validate()

        then: "validation should fail because memorrialUpdateTimestamp is required field but is empty"
        memorial.hasErrors()
        memorial.errors.getErrorCount()==1
        assert memorial.errors.getFieldError("memorrialUpdateTimestamp") != null

        when: "memorrialUpdateTimestamp is empty"
        Memorial memorial1 = new Memorial();
        memorial1.validate()

        then: "validation should fail because memorrialUpdateTimestamp is required field but is empty"
        memorial1.hasErrors()
        memorial1.errors.getErrorCount()==7

    }

    void "Test name cannot"() {

    }
}
