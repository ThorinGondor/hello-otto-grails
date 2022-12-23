package hello.otto.grails

import grails.gorm.services.Query
import grails.gorm.services.Service
import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@Service(UserDetail)
interface UserDetailService {

    @ReadOnly
    UserDetail get(Serializable id)

    @ReadOnly
    List<UserDetail> list(Map args)

    @ReadOnly
    Long count()

    @Transactional
    void delete(Serializable id)

    @Transactional
    UserDetail save(UserDetail userDetail)

    @Transactional
    @Query("update ${UserDetail ud} set ${ud.team} = $team where ${ud.id} = ${id}")
    Integer myUpdate(Long id, String team)
}