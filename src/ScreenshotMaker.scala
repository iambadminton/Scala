/**
  * Created by a.shipulin on 27.06.16.
  */
import java.awt._
import java.io._
import javax.imageio._

object ScreenshotMaker extends App {
  def executableName : String = {
    System.getProperty("sun.java.command")
  }

  def makeScreenshot(fileName: String) {
    val toolkit = Toolkit.getDefaultToolkit
    val rect = new Rectangle(toolkit.getScreenSize)
    val capture = new Robot().createScreenCapture(rect)
    ImageIO.write(capture, "png", new File(fileName))
  }

  if(args.isEmpty) {
    println(s"Usage: ${executableName} screenshot.png")
  } else {
    makeScreenshot(args(0))
  }




}
