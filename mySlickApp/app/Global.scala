import play.api.db.DB
import play.api.GlobalSettings
import scala.slick.driver.H2Driver.simple._
import Database.threadLocalSession
import play.api.Application
import play.api.Play.current
import models.Bars

object Global extends GlobalSettings {

  override def onStart(app: Application) {

    lazy val database = Database.forDataSource(DB.getDataSource())
    database.withSession {

      Bars.ddl.create

    }
  }

}