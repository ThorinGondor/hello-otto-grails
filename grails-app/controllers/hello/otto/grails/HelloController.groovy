package hello.otto.grails

class HelloController {

    def index() {
        render 'Hello World!'
    }

    def closureDemo() {
        def name = 'Chen'
        def closure = { print("NAME: ${name}") } // 闭包是在运行时才取变量的值
        name = 'Wang'
        closure()
        render 'SUCCESS'
    }

    // http://localhost:7950/hello/dynamicParamsDemo?name=Brooks&age=18
    def dynamicParamsDemo(String name) {
        def age = params.age
        [p_name: name, p_age: age]
    }

    // http://localhost:7950/hello/ajaxDemo?n1=Seven&n2=Tiga
    def ajaxDemo() {

    }

    def ajaxRequest(String p1, String p2) {
        render "n1 + n2: ${p1} ~~ ${p2}"
    }

    def ajaxRequest2(String p1, String p2) {
        render "n1 + n2: ${p1} ++ ${p2}"
    }
}
