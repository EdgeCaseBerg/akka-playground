package services

import akka.io.IO
import akka.actor._
import scala.sys.process.Process

object CommandActor {
	case class Run(cmd: String)
	case class Result(exitValue: Int)
}

class CommandActor extends Actor {
	def receive = {
		case CommandActor.Run(cmd) =>
			val process = Process(cmd).run
			sender ! CommandActor.Result(process.exitValue)
	}
} 
