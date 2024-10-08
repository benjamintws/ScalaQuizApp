package ch.makery.address

import ch.makery.address.view
import ch.makery.address.model.Music
import ch.makery.address.view.ResultsController
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafxml.core.{FXMLLoader, NoDependencyResolver}
import scalafx.Includes._
import javafx.{scene => jfxs}

object MainApp extends JFXApp {

  var currentMusic: Option[Music] = None

  // transform path of RootLayout.fxml to URI for resource location.
  val rootResource = getClass.getResource("view/RootLayout.fxml")

  // initialize the loader object.
  val loader = new FXMLLoader(rootResource, NoDependencyResolver)

  // Load root layout from fxml file.
  loader.load();

  // retrieve the root component BorderPane from the FXML
  // scalafx.Includes._ auto converts the jfxs
  val roots = loader.getRoot[jfxs.layout.BorderPane]

  // Initialise the stage
  stage = new PrimaryStage {
    title = "Football Quiz App"
    scene = new Scene {
      root = roots
    }
  }

  def stopCurrentMusic(): Unit = {
    currentMusic.foreach(_.stop())
  }

  // Defining all getters for each page
  def showWelcome(): Unit = {
    val resource = getClass.getResource("view/Welcome.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  def showHomepage() = {
    stopCurrentMusic()
    val homepageMusic = new Music("src/main/resources/ch/makery/address/view/homepageBGM.mp3")
    homepageMusic.play()
    currentMusic = Some(homepageMusic)

    val resource = getClass.getResource("view/Homepage.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  def showQuiz1()  = {
    stopCurrentMusic()
    val quiz1Music = new Music("src/main/resources/ch/makery/address/view/Quiz1bgm.mp3")
    quiz1Music.play()
    currentMusic = Some(quiz1Music)

    val resource = getClass.getResource("view/Quiz1.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  def showQuiz2()  = {
    stopCurrentMusic()
    val quiz2Music = new Music("src/main/resources/ch/makery/address/view/Quiz2bgm.mp3")
    quiz2Music.play()
    currentMusic = Some(quiz2Music)

    val resource = getClass.getResource("view/Quiz2.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  def showQuiz3()  = {
    stopCurrentMusic()
    val quiz3Music = new Music("src/main/resources/ch/makery/address/view/Quiz3bgm.mp3")
    quiz3Music.play()
    currentMusic = Some(quiz3Music)

    val resource = getClass.getResource("view/Quiz3.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  def showHowToPlay(): Unit = {
    val resource = getClass.getResource("view/HowToPlay.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  val score = 0

  def showResults(correctAnswers: Int, totalQuestions: Int): Unit = {
    stopCurrentMusic()
    val resultsMusic = new Music("src/main/resources/ch/makery/address/view/resultsBGM.mp3")
    resultsMusic.play()
    currentMusic = Some(resultsMusic)

    val resource = getClass.getResource("view/Results.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)

    // Pass the score to ResultsController
    val resultsController = loader.getController[ResultsController#Controller]
    resultsController.setScore(correctAnswers, totalQuestions)
  }

  // Initialise the first page, Welcome page
  showWelcome()

}