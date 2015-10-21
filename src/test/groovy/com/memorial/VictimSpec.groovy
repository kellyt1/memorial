package com.memorial

import grails.test.mixin.TestFor
import org.junit.Test
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Victim)
class VictimSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @Test
    void "test all constraints on Victim object"() {
        given:"all required fields are set"
        Victim victim = new Victim(victimFirstName: "alpha")

        when:"application is validated"
        victim.validate()

        then:"then no validation errors should be present"
        assert !victim.hasErrors()
    }
}
