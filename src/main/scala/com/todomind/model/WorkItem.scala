package com.todomind.model

case class WorkItem(description:String, importance:Int, subItems: Seq[WorkItem]) {
  
}
