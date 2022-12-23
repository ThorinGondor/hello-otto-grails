package hello.otto.grails

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class UserDetailInterceptorSpec extends Specification implements InterceptorUnitTest<UserDetailInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test otto interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"otto")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
