package com.todomind.model.ideas

import com.github.nscala_time.time.{Imports => Joda}
object Types {
  type DatetimeType = Joda.DateTime
  type DurationType = Joda.Period
  type IntervalType = Joda.Interval
}
import com.todomind.model.ideas.Types._

case class TimeSlot(start:DatetimeType,end:DatetimeType) {
  val duration: Duration = SimpleDuration(new Joda.Period(start,end))
}


abstract class Duration{
  protected def copyWithvalue(value:DurationType):Duration
  def + (duration: Duration): Duration = copyWithvalue(value.plus(duration.value))
  val value: Types.DurationType

  def canEqual(other: Any): Boolean = other.isInstanceOf[Duration]

  override def equals(other: Any): Boolean = other match {
    case that: Duration =>
      (that canEqual this) &&
        value == that.value
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(value)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
case class SimpleDuration(value:DurationType) extends Duration {
  override protected def copyWithvalue(value: DurationType): Duration = SimpleDuration(value)
}

class DiscreteDuration(val value: DurationType) extends Duration {
  def stepInMinutes: Int = ???

  override protected def copyWithvalue(value: DurationType): Duration = ???
}

trait Estimate {
  def expected:Duration
}
object Estimate {
  val maxAcceptedEstimate:Duration = ??? //TODO:Make this a setting
}
trait ProbEstimate extends Estimate {
  def worst:Duration
  def best:Duration
}

trait Datetime {
  def value: DatetimeType
  protected def copyWithValue(value: DatetimeType):Datetime

  def +(duration: Duration): Datetime = copyWithValue(value.plus(duration.value))

  def -(duration: Duration): Datetime = copyWithValue(value.minus(duration.value))
}
class DiscreteDatetime extends Datetime {
  def stepInMinutes: Int = ???

  override protected def copyWithValue(value: DatetimeType): Datetime = ???

  override def value: DatetimeType = ???
}
