package hello.otto.grails

class UserAward {

    Long id
    String awardName
    Integer point
    Date insertTime
    Boolean isDeleted
    User theUser // 这里我故意写成 theUser 而非 user，然后我们可以通过 static mapping 进行字段匹配

    static constraints = {
        id nullable: false
        isDeleted nullable: false
    }

    static mapping = {
        theUser column: "user_id"
    }
}
