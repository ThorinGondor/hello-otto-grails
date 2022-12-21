package hello.otto.grails

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class UserDetailServiceSpec extends Specification {

    UserDetailService userDetailService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new UserDetail(...).save(flush: true, failOnError: true)
        //new UserDetail(...).save(flush: true, failOnError: true)
        //UserDetail userDetail = new UserDetail(...).save(flush: true, failOnError: true)
        //new UserDetail(...).save(flush: true, failOnError: true)
        //new UserDetail(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //userDetail.id
    }

    void "test get"() {
        setupData()

        expect:
        userDetailService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<UserDetail> userDetailList = userDetailService.list(max: 2, offset: 2)

        then:
        userDetailList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        userDetailService.count() == 5
    }

    void "test delete"() {
        Long userDetailId = setupData()

        expect:
        userDetailService.count() == 5

        when:
        userDetailService.delete(userDetailId)
        sessionFactory.currentSession.flush()

        then:
        userDetailService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        UserDetail userDetail = new UserDetail()
        userDetailService.save(userDetail)

        then:
        userDetail.id != null
    }
}
