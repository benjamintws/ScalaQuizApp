package ch.makery.address.view

import ch.makery.address.MainApp
import ch.makery.address.model.{Question, Questions}
import scalafx.scene.control.{Button, Label}
import scalafxml.core.macros.sfxml
import scalafx.event.ActionEvent
import scalafx.Includes._


@sfxml
class Quiz3Controller(
                       private val questionLabel: Label,
                       private val opt1: Button,
                       private val opt2: Button,
                       private val opt3: Button,
                       private val opt4: Button
                     ) {
  // Load the questions
  private val questions = new Questions()
  private val quizCategory = "World Cup History"
  private var currentQuestionIndex = 0
  private var correctAnswers = 0
  private val questionSet: List[Question] = questions.getQuestionsByCategory(quizCategory).getOrElse(List())

  // Initialize the first question
  if (questionSet.nonEmpty) {
    loadQuestion(questionSet(currentQuestionIndex))
  }

  // Method to load a question into the UI
  private def loadQuestion(question: Question): Unit = {
    questionLabel.text = question.questionText
    opt1.text = question.options(0)
    opt2.text = question.options(1)
    opt3.text = question.options(2)
    opt4.text = question.options(3)
  }

  // Handle button clicks for each option
  def handleOptionSelected(event: ActionEvent): Unit = {
    val selectedButton: scalafx.scene.control.Button = event.source.asInstanceOf[javafx.scene.control.Button]
    val selectedIndex = List(opt1, opt2, opt3, opt4).indexOf(selectedButton)

    // Check if the selected answer is correct
    if (selectedIndex == questionSet(currentQuestionIndex).correctAnswer) {
      correctAnswers += 1
    }

    // Move to the next question, shows result page if no questions left
    currentQuestionIndex += 1
    if (currentQuestionIndex < questionSet.length) {
      loadQuestion(questionSet(currentQuestionIndex))
    } else {
      getResults()
    }
  }

  // Method to show the result page
  def getResults(): Unit = {
    MainApp.showResults(correctAnswers, questionSet.length)
  }
}
