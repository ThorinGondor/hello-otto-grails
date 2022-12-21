package hello.otto.grails

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class UserDetailSpec extends Specification implements DomainUnitTest<UserDetail> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
