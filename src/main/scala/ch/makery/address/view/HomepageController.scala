package ch.makery.address.view

import ch.makery.address.MainApp
import scalafx.scene.control.TextField
import scalafxml.core.macros.sfxml

@sfxml
class HomepageController{
  def getQuiz1(): Unit = {
    MainApp.showQuiz1()
  }

  def getQuiz2(): Unit = {
    MainApp.showQuiz2()
  }

  def getQuiz3(): Unit = {
    MainApp.showQuiz3()
  }

  def getHowToPlay(): Unit = {
    MainApp.showHowToPlay()
  }
}
