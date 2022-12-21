package hello.otto.grails

import grails.gorm.multitenancy.Tenant
import grails.gorm.services.Query
import grails.gorm.services.Service

@Service(User)
interface UserService {

    User get(Serializable id)

    List<User> list(Map args)

    Long count()

    void delete(Serializable id)

    User save(User user)

}