package hello.otto.grails

class User {
    Long id

    String name

    Boolean isDeleted

    Integer version

    Date insertTime

    Date updateTime

    static hasMany = [userAwards: UserAward]

    static mappedBy = [userAwards: "theUser"]

}
