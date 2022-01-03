package com.mousami.grails.guestbook

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CommentServiceSpec extends Specification {

  /*  CommentService commentService
    SessionFactory sessionFactory

    private Long setupData() {
         User user1 = new User(name:'lars', email:'muster@muster.com', webpage:'http://www.vogella.com')
        User otherUser = new User(name:'jim', email:'jim@muster.com', webpage:'http://www.vogella.com')
        Feedback feedback1 = new Feedback(title:'First feedback', feedback:'This is my first feedback', user:user1)


   
        // TODO: Populate valid domain instances and return a valid ID
       Comment comment1=  new Comment(comment:'Hello  my name is Jim',feedback:feedback1, user:user1).save(flush: true, failOnError: true)
       
     // Comment comment2=  new Comment(comment:'Hello, my name is tim',feedback:feedback1, user:user1).save(flush: true, failOnError: true)

     //   Comment comment = new Comment(comment:'Hello, my name is kim',feedback:feedback1, user:user1).save(flush: true, failOnError: true)
      
    //  Comment comment3=  new Comment(comment:'Hello, my name is rim', feedback:feedback1,user:user1).save(flush: true, failOnError: true)
    
     //Comment comment4=   new Comment(comment:'Hello, my name is jjim',feedback:feedback1,user:user1).save(flush: true, failOnError: true)
       
        //assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        comment1.id
    }

    void "test get"() {
        setupData()

        expect:
        commentService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Comment> commentList = commentService.list(max: 2, offset: 2)

        then:
        commentList.size() == 2
        //assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        commentService.count() == 1
    }

    void "test delete"() {
        Long commentId = setupData()

        expect:
        commentService.count() == 1

        when:
        commentService.delete(commentId)
        sessionFactory.currentSession.flush()

        then:
        commentService.count() == 1
    }

    void "test save"() {
        when:
        //assert false, "TODO: Provide a valid instance to save"
         User user1 = new User(name:'laddsdsr7s', email:'muster@muster.com', webpage:'http://www.vogella.com')
         Feedback feedback1 = new Feedback(title:'Fyuy feedback', feedback:'This is mydsfdfdfd first feedback', user:user1)


   
        // TODO: Populate valid domain instances and return a valid ID
       Comment comment1=  new Comment(comment:'Hello, my name is Jim',feedback:feedback1 , user:user1).save(flush: true, failOnError: true)
        //Comment1.feedback=feedback
        
       // Comment comment = new Comment()
        commentService.save(comment)

        then:
        comment1.id != null
    }*/
}
