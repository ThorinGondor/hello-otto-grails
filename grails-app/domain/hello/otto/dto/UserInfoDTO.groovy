package hello.otto.dto

import hello.otto.grails.User
import hello.otto.grails.UserAward
import hello.otto.grails.UserDetail

class UserInfoDTO {

    User user

    List<UserAward> awards

    static constraints = {
    }
}
