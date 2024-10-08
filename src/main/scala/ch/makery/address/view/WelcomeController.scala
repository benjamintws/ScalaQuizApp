package ch.makery.address.view

import ch.makery.address.MainApp
import scalafxml.core.macros.sfxml

@sfxml
class WelcomeController{
  def getWelcome(): Unit = {
    MainApp.showWelcome()
  }

  def getHomepage(): Unit = {
    MainApp.showHomepage()
  }
}