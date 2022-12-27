package hello.otto.grails

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class UserAwardSpec extends Specification implements DomainUnitTest<UserAward> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
