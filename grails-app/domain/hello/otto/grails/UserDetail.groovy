package hello.otto.grails

class UserDetail {

    Long id
    Long userId
    String team
    String district
    String language
    String profession
    Date insertTime
    Date update_time
    Boolean isDeleted

    static constraints = {
        id nullable: false
        userId nullable: false
        isDeleted nullable: false
    }
}
