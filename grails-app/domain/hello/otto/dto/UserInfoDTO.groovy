package hello.otto.dto

import hello.otto.grails.User
import hello.otto.grails.UserDetail

class UserInfoDTO {

    User user

    List<UserDetail> details

    static constraints = {
    }
}
