package hello.otto.grails

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class UserAwardServiceSpec extends Specification {

    UserAwardService userAwardService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new UserAward(...).save(flush: true, failOnError: true)
        //new UserAward(...).save(flush: true, failOnError: true)
        //UserAward userAward = new UserAward(...).save(flush: true, failOnError: true)
        //new UserAward(...).save(flush: true, failOnError: true)
        //new UserAward(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //userAward.id
    }

    void "test get"() {
        setupData()

        expect:
        userAwardService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<UserAward> userAwardList = userAwardService.list(max: 2, offset: 2)

        then:
        userAwardList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        userAwardService.count() == 5
    }

    void "test delete"() {
        Long userAwardId = setupData()

        expect:
        userAwardService.count() == 5

        when:
        userAwardService.delete(userAwardId)
        sessionFactory.currentSession.flush()

        then:
        userAwardService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        UserAward userAward = new UserAward()
        userAwardService.save(userAward)

        then:
        userAward.id != null
    }
}
