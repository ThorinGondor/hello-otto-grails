package hello.otto.grails

/**
 * 全局拦截器
 */
class OttoInterceptor {

    OttoInterceptor() {
        matchAll().excludes(controller: "login")
    }

    boolean before() {
        println(">>> OttoInterceptor Before <<<")
        true
    }

    boolean after() {
        println(">>> OttoInterceptor After <<<")
        true
    }

    void afterView() {
        // no-op
    }
}
