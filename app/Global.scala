import play.api._
import sys.process._
import paas.RunnerApplication
import scala.language.postfixOps

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    Logger.info("Application has started")
    RunnerApplication.main(Array("Master"))
    val str = s"mkdir -p /root/jars/"
    if((Process(str) !) != 0)
      Logger.info("Error while creating jar directory")
  }

  override def onStop(app: Application) {
    Logger.info("Application shutdown...")
  }

}
