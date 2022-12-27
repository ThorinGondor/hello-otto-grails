package hello.otto.grails

import grails.gorm.services.Service

@Service(UserAward)
interface UserAwardService {

    UserAward get(Serializable id)

    List<UserAward> list(Map args)

    Long count()

    void delete(Serializable id)

    UserAward save(UserAward userAward)

}