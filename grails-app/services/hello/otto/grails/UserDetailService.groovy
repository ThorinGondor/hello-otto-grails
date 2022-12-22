package hello.otto.grails

import grails.gorm.services.Query
import grails.gorm.services.Service

@Service(UserDetail)
interface UserDetailService {

    UserDetail get(Serializable id)

    List<UserDetail> list(Map args)

    Long count()

    void delete(Serializable id)

    UserDetail save(UserDetail userDetail)

    @Query("update ${UserDetail ud} set ${ud.team} = $team where ${ud.id} = ${id}")
    Integer myUpdate(Long id, String team)
}