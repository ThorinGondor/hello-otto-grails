package hello.otto.grails

/**
 * 全局拦截器
 */
class OttoInterceptor {

    OttoInterceptor() {
        // 除了 */login 不拦截，其他请求一律拦截
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
