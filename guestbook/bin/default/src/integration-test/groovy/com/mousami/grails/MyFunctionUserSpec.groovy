package com.mousami.grails
import grails.testing.mixin.integration.Integration
import grails.transaction.*
import spock.lang.Specification
import spock.lang.*

import geb.spock.*
import geb.Browser

/*
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
//@Rollback
//static baseUrl {'http://localhost:8080' }
class MyFunctionUserSpec extends GebReportingSpec {

    def setup() {
       
                }

    def cleanup() {
                }
    void "Test the home page renders correctly"() {
        when:"The home page is visited"
            go '/'

        then:"The title is correct"
            $('h1').text() == "Welcome to Grails"
    }
    def "Create user"(){
        when:
        reportGroup "User"
        go "user/create"
        report "user page"
        then:
        $("h1").text() == "Create User"
 
        when:
         $("form").name = "AbcMouse"
        $("form").email ="user1@example.com"
      $("form").webpage="http://www.user.com"
        report "Filled user info"
       $("input",name:"create").click()
      
        then:
   
        $("h1").text() == "Show User"

         report "newly added user"

    }
    def "Create FeedBack"(){
        when:
        reportGroup "FeedBack"
        go "feedback/create"
 
        then:
        $("h1").text() == "Create Feedback"
        report "Feedback creation page "
        when:
         $("form").title = "First Title"
        $("form").feedback ="My first feedback"
        $("form")."user.id"= "AbcMouse"
        report "Newly created Feedback"
       $("input",name:"create").click()
        
        then:
   
        $("h1").text() == "Show Feedback"
         report "Feedback list "

    }
    def "Create Comment"(){
        when:
        go "comment/create"
 
        then:
        $("h1").text() == "Create Comment"
 
        when:
         $("form").comment = "my First comment"
        $("form")."user.id" ="AbcMouse"
        $("form")."feedback.id"= 22
       $("input",name:"create").click()
   
        then:
   
        $("h1").text() == "Show Comment"

         

    }
  def "Create user1"(){
        when:
        go "user/create"
 
        then:
        $("h1").text() == "Create User"
 
        when:
         $("form").name = "Testuser"
        $("form").email ="testuser@example.com"
      $("form").webpage="http://www.testuser.com"
       $("input",name:"create").click()
   
        then:
   
       $("h1").text() == "Show User"

    }
    def "Create FeedBack1"(){
        when:
        go "feedback/create"
 
        then:
        $("h1").text() == "Create Feedback"
 
        when:
         $("form").title = "Second Title"
        $("form").feedback ="My Second feedback"
        $("form")."user.id" = "Testuser"
       $("input",name:"create").click()
   
        then:
   
        $("h1").text() == "Show Feedback"

         

    }
     def "Create Comment1"(){
        when:
        go "comment/create"
 
        then:
        $("h1").text() == "Create Comment"
 
        when:
         $("form").comment = "my secondcomment"
        $("form")."user.id" ="Testuser"
        $("form")."feedback.id"= 23
       $("input",name:"create").click()
   
        then:
   
        $("h1").text() == "Show Comment"

         

    }
  def "Create user2"(){
        when:
        go "user/create"
 
        then:
        $("h1").text() == "Create User"
 
        when:
         $("form").name = "Mouse"
        $("form").email ="moues@example.com"
      $("form").webpage="http://www.usermouse.com"
       $("input",name:"create").click()
   
        then:
   
        $("h1").text() == "Show User"

         

    }
    def "Create FeedBack2"(){
        when:
        go "feedback/create"
 
        then:
        $("h1").text() == "Create Feedback"
 
        when:
         $("form").title = "Third Title"
        $("form").feedback ="My Thirdfeedback"
          $("form")."user.id" = "Mouse"
       $("input",name:"create").click()
   
        then:
   
        $("h1").text() == "Show Feedback"

         

    }
     def "Create Comment2"(){
        when:
        go "comment/create"
 
        then:
        $("h1").text() == "Create Comment"
 
        when:
         $("form").comment = "my third comment"
        $("form")."user.id" ="Mouse"
        $("form")."feedback.id"= 24
       $("input",name:"create").click()
   
        then:
   
        $("h1").text() == "Show Comment"

         

    }
  def "Create user3"(){
        when:
        go "user/create"
 
        then:
        $("h1").text() == "Create User"
 
        when:
         $("form").name = "Elephant"
        $("form").email ="userelephant@example.com"
      $("form").webpage="http://www.userzoo.com"
       $("input",name:"create").click()
   
        then:
   
        $("h1").text() == "Show User"

         

    }
 def "Create FeedBack3"(){
        when:
        go "feedback/create"
 
        then:
        $("h1").text() == "Create Feedback"
 
        when:
         $("form").title = "Fourth Title"
        $("form").feedback ="My fourth feedback"
        $("form")."user.id" = "Elephant"
       $("input",name:"create").click()
   
        then:
   
        $("h1").text() == "Show Feedback"

         

    }
    def "Create Comment3"(){
        when:
        go "comment/create"
 
        then:
        $("h1").text() == "Create Comment"
 
        when:
         $("form").comment = "my fourth  comment"
        $("form")."user.id" ="Elephant"
        $("form")."feedback.id"= 25
       $("input",name:"create").click()
   
        then:
   
        $("h1").text() == "Show Comment"

         

    }
    def "Show user List"(){
        when:
        go "user/index"
 
        then:
        $("h1").text() == "User List"
        
        when: 'edit user '
         $("td a", 0).click()
           then:'delete user'
        $("h1").text() == "Show User"
        //$("input.delete").click()
        //   $("h1").text() == "User List"
        }
        def "Show feedback List"(){
        when:
        go "feedback/index"
 
        then:
        $("h1").text() == "Feedback List"
        
        //when: 'edit user '
       //  $("td a", 0).click()
       //    then:'delete user'
       // $("h1").text() == "Show User"
        //$("input.delete").click()
        //   $("h1").text() == "User List"
        }
 
 def "Show Comment List"(){
        when:
        go "Comment/index"
 
        then:
        $("h1").text() == "Comment List"
        
        //when: 'edit user '
       //  $("td a", 0).click()
       //    then:'delete user'
       // $("h1").text() == "Show User"
        //$("input.delete").click()
        //   $("h1").text() == "User List"
        }
 
}
