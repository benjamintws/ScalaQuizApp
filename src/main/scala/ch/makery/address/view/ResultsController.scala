package ch.makery.address.view

import ch.makery.address.MainApp
import scalafx.scene.control.Label
import scalafxml.core.macros.sfxml

@sfxml
class ResultsController(
                         private val finalscore: Label,
                         private val textdisplay: Label
                       ) {

  // Variable to store the number of correct answers and total questions
  private var correctAnswers: Int = 0
  private var totalQuestions: Int = 1

  // Method to set the score and display the appropriate message
  def setScore(correct: Int, total: Int): Unit = {
    correctAnswers = correct
    totalQuestions = total

    // Calculate the score as correct answers / total questions
    finalscore.text = s"$correctAnswers/$totalQuestions"

    // Display appropriate message based on performance
    val percentage = (correctAnswers.toDouble / totalQuestions) * 100
    textdisplay.text = percentage match {
      case x if x >= 80 => "CONGRATULATIONS!"
      case x if x >= 50 => "GOOD JOB!"
      case _            => "BETTER LUCK NEXT TIME"
    }
  }

  def getHomepage(): Unit = {
    MainApp.showHomepage()
  }

}
