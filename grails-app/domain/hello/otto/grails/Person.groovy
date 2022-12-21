package hello.otto.grails

class Person {

    String name
    String country
    String gender
    Integer age
    Boolean active

    static constraints = {
        name nullable: true, maxSize: 100
        country nullable: true, maxSize: 100
        gender nullable: true, inList: ['male', 'female']
        age nullable: true
        active nullable: false
    }
}
