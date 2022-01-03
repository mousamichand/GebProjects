package com.mousami.grails.guestbook

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class FeedbackServiceSpec extends Specification {

    FeedbackService feedbackService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        User user1 = new User(name:'lars', email:'muster@muster.com', webpage:'http://www.vogella.com')
        new Feedback(title:'First feedback', feedback:'This is my first feedback', user:user1).save(flush: true, failOnError: true)
        new Feedback(title:'second feedback', feedback:'This is my second feedback', user:user1).save(flush: true, failOnError: true)
        Feedback feedback = new Feedback(title:'third feedback', feedback:'This is my third feedback', user:user1).save(flush: true, failOnError: true)
        new Feedback(title:'Fourth feedback', feedback:'This is my fourth feedback', user:user1).save(flush: true, failOnError: true)
        new Feedback(title:'Fifthfeedback', feedback:'This is my fifth feedback', user:user1).save(flush: true, failOnError: true)
        //assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        feedback.id
    }

    void "test get"() {
        setupData()

        expect:
        feedbackService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Feedback> feedbackList = feedbackService.list(max: 2, offset: 2)

        then:
        feedbackList.size() == 2
       // assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        feedbackService.count() == 5
    }

    void "test delete"() {
        Long feedbackId = setupData()

        expect:
        feedbackService.count() == 5

        when:
        feedbackService.delete(feedbackId)
        sessionFactory.currentSession.flush()

        then:
        feedbackService.count() == 4
    }

    void "test save"() {
        when:
       // assert false, "TODO: Provide a valid instance to save"
         User user1 = new User(name:'lars', email:'muster@muster.com', webpage:'http://www.vogella.com')
       Feedback feedback= new Feedback(title:'First feedback', feedback:'This is my first feedback', user:user1).save(flush: true, failOnError: true)
        feedbackService.save(feedback)

        then:
        feedback.id != null
    }
}
