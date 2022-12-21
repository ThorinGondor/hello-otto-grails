package hello.otto.grails

class Pet {

    // 物种
    String species

    String name

    static constraints = {
        species nullable: true, maxSize: 100
        name nullable: true, maxSize: 100
    }
}
