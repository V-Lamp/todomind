package com.todomind.model.ideas

import java.util.UUID
trait Identifiable {
  def guid: UUID

}
trait WorkItem extends Identifiable {
  def shortDescr: String
  def longDescr: String
  def tags: Seq[Tag]
  def importance: Importance
}

object Identifiable {
  def generateGuid = java.util.UUID.randomUUID
}

trait FixedTask extends WorkItem {
  def startingTime: Datetime
  def endingTime: Datetime
}

trait WorkingTimeWindow

trait Deadlined {
  self: WorkItem =>
  def deadline: Datetime
}

//case class Task(
//                 guid: UUID,
//                 shortDescr: String,
//                 longDescr: String,
//                 subTasks: Seq[Task],
//                 tags: Seq[Tag],
//                 importance: Int,
//                 duration: Duration,
//                 due: Datetime,
//                 scheduled: Datetime) extends WorkItem


case class Tag(name: String) extends Identifiable {
  override def guid = Identifiable.generateGuid
}

class Importance private(/** less is more important */
                         val order: Int)

object Importance {

  case object High extends Importance(0)

  case object Medium extends Importance(1)

  case object Low extends Importance(2)

  case object Unassigned extends Importance(3)

  val default = Unassigned
}


