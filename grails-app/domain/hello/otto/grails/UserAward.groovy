package hello.otto.grails

class UserAward {

    Long id
    String awardName
    Integer point
    Date insertTime
    Boolean isDeleted
    User user

    static constraints = {
        id nullable: false
        isDeleted nullable: false
    }
}
