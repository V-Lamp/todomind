package com.todomind.planning

import com.todomind.SimpleSpecs
import com.todomind.model.WorkItem
import org.scalatest._


class PlannerSPecs extends SimpleSpecs {
  "A planner" when {
    val planner = new Planner()
    "provided with a list of nested workItems with priorities" should {
      val workItems: Seq[WorkItem] = Seq()
      "produce a plan " which {
        "contains all provided work items" in  pending

        "order items by by priority then by provided order respecting nesting" in pending

        "only provide a list of correctly ordered tasks that can be finished in a given time, not double-counting subtask estimates" in pending

        "only get a list tasks ordered by deadline then other criteria that can be finished in a given time and respect all deadlines or be warned about infeasible deadline" in pending
      }
    }

  }
}

