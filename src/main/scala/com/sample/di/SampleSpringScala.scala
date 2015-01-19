package com.sample.di

import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired
import scala.beans.BeanProperty

object SampleSpringScala extends App {

  val applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml")

  val userService = applicationContext.getBean("simpleUserService", classOf[UserService])
  val testuserService = applicationContext.getBean("testSimpleUserService", classOf[UserService])

  println(userService.getUserByUserName("real"))
  println(testuserService.getUserByUserName("test"))
}

trait UserService {
  def getUserByUserName(userName: String): Option[User]
}
@Component
class TestSimpleUserService extends UserService {
  @Autowired
  var otherService: OtherService = _
  private def Users = Map("test" -> User("X54532", "Test", "User"))
  def getUserByUserName(userName: String) = {
    otherService.print
    Users get userName
  }
}
case class User(customerNumber: String, firstName: String, lastName: String)

@Component
class SimpleUserService extends UserService {

  private def Users = Map("real" -> User("X54532", "Real", "User"))
  @Autowired
  var otherService: OtherService = _

  def getUserByUserName(userName: String) = {
    otherService.print
    Users get userName
  }
}
@Component
class OtherService {
  def print {
    println("print method invoked")
  }
}