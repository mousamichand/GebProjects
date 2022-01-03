package com.mousami.grails.guestbook

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class UserServiceSpec extends Specification {

    UserService userService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        new User(name:'mchand', email:'mchand3@gmail.com', webpage:'http://www.abcfriend.com').save(flush: true, failOnError: true)
        new User(name:'Ppal', email:'ppal233@gmail.com', webpage:'http://www.ppaltestfriend.com').save(flush: true, failOnError: true)
        User user = new User(name:'Sady', email:'sandysingh@gmail.com', webpage:'http://www.sandysingh.com').save(flush: true, failOnError: true)
        new User(name:'mukku', email:'phjhj233@gmail.com', webpage:'http://www.abcfriend.com').save(flush: true, failOnError: true)
        new User(name:'Orishu', email:'qwerty@gmail.com', webpage:'http://www.qwertytestfriend.com').save(flush: true, failOnError: true)
        //assert false,user
        
        user.id
       
    }

    void "test get"() {
        setupData()

        expect:
        print "test"
      //  userService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<User> userList = userService.list(max: 2, offset: 2)

        then:
        userList.size() == 2
        assert userList.size() == 2
    }

    void "test count"() {
        setupData()

        expect:
        userService.count() == 5
    }

    void "test delete"() {
        Long userId = setupData()

        expect:
        userService.count() == 5

        when:
        userService.delete(userId)
        sessionFactory.currentSession.flush()

        then:
        userService.count() == 4
    }

    void "test save"() {
        when:
        //assert false, "TODO: Provide a valid instance to save"
        User usertest = new User(name:'testy', email:'testh@gmail.com', webpage:'http://www.testsingh.com').save(flush: true, failOnError: true)
        userService.save(usertest)

        then:
        usertest.id != null
    }
}
