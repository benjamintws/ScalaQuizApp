package ch.makery.address.view

import ch.makery.address.MainApp
import scalafx.scene.control.TextField
import scalafxml.core.macros.sfxml

@sfxml
class HTPController{

  def getHowToPlay(): Unit = {
    MainApp.showHowToPlay()
  }

  def getHomepage(): Unit = {
    MainApp.showHomepage()
  }
}