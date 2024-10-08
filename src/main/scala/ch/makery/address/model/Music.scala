package ch.makery.address.model

import javafx.scene.media.{Media, MediaPlayer}
import java.io.File

class Music(val fileName: String) {

  // Loads music
  private val media = new Media(new File(fileName).toURI.toString)
  private val mediaPlayer = new MediaPlayer(media)

  // Method to play music
  def play(loop: Boolean = true): Unit = {
    if (loop) {
      mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE) // Loop indefinitely
    }
    mediaPlayer.play()
  }

  // Method to stop music
  def stop(): Unit = {
    mediaPlayer.stop()
  }

  object Music {
    private var activeMusic: List[Music] = List()

    // Register a new music instance
    // Current playing music is added here
    private def register(music: Music): Unit = {
      activeMusic = music :: activeMusic
    }

    // Stop all currently playing music
    def stopAllMusic(): Unit = {
      activeMusic.foreach(_.stop())
      activeMusic = List() // Clear the list after stopping
    }
  }
}