package hello.otto.grails

/**
 * 拦截器，默认前缀名称和 Controller 一致：UserDetailInterceptor --> UserDetailController
 * 若需要拦截其他请求，可以使用 match\matchAll
 */
class UserDetailInterceptor {

    boolean before() {
        println("UserDetailInterceptor Before ====> ")
        true
    }

    boolean after() {
        println("UserDetailInterceptor After ====> ")
        true
    }

    void afterView() {
        // no-op
    }
}
