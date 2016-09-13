package com.todomind.ui





import javafx.stage.StageStyle

import com.sun.deploy.uitoolkit.DragContext

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.beans.property.BooleanProperty
import scalafx.collections.ObservableBuffer
import scalafx.geometry.{Insets, Pos}
import scalafx.scene.control._
import scalafx.scene.input.MouseEvent
import scalafx.scene.layout._
import scalafx.scene.{Group, Node, Scene}
/**
  * Created by Bill on 29/03/2016.
  */
object Main extends JFXApp {
  stage = new PrimaryStage {
    initStyle(StageStyle.TRANSPARENT)
    title.value = "Hello Stage"
    width = 600
    height = 120

    scene = new Scene {
      root = new BorderPane with SceneResizer{

      }
    }
  }
}

trait SceneDragger extends DraggableNode{
  self: scalafx.scene.Node =>

  override def onDraggedWithDelta(dx: Double, dy: Double): Unit = {
    val window = scene.window.get()
    window.setX(window.getX + dx)
    window.setY(window.getY + dy)
  }
}
trait SceneResizer extends DraggableNode{
  self: Node =>

  override def onDraggedWithDelta(dx: Double, dy: Double): Unit = {
    val window = scene.window.get()
    window.setWidth(window.getWidth + dx)
    window.setHeight(window.getHeight + dy)
  }
}

trait DraggableNode {
  self: scalafx.scene.Node =>
  private def makeDraggable(node: Node) = {

    //val dragContext = new DragContext()

//    new Group(node) {
//      filterEvent(MouseEvent.Any) {
//        (me: MouseEvent) =>
//          if (dragModeActiveProperty()) {
//            me.eventType match {
//              case MouseEvent.MousePressed =>
//                dragContext.mouseAnchorX = me.x
//                dragContext.mouseAnchorY = me.y
//                dragContext.initialTranslateX = node.translateX()
//                dragContext.initialTranslateY = node.translateY()
//              case MouseEvent.MouseDragged =>
//                node.translateX = dragContext.initialTranslateX + me.x - dragContext.mouseAnchorX
//                node.translateY = dragContext.initialTranslateY + me.y - dragContext.mouseAnchorY
//              case _ =>
//            }
//            me.consume()
//          }
//      }
//    }
  }
  def onDraggedWithDelta(dx: Double,dy:Double):Unit

  private var previousDragPosition : Option[(Double,Double)] = None

  def dragDelta(x:Double,y:Double)= previousDragPosition.map(start => (x - start._1, y - start._2))
  def dragDelta(mouseEvent: MouseEvent)= previousDragPosition.map(start => (mouseEvent.screenX - start._1, mouseEvent.screenY - start._2))

  //self.addEventFilter(MouseEvent.MousePressed,(e: MouseEvent) => previousDragPosition = Some((e.screenX,e.screenY)))


  onMousePressed = (e: MouseEvent) => previousDragPosition = Some((e.screenX,e.screenY))

  onMouseReleased = (e: MouseEvent) => previousDragPosition = None

  onMouseDragged = (e:MouseEvent) => {
    val prevDragPos = previousDragPosition.getOrElse(throw new Exception("Invalid logic with drag"))
    onDraggedWithDelta(e.screenX-prevDragPos._1, e.screenY - prevDragPos._2)
    previousDragPosition = Some((e.screenX,e.screenY))
  }
}

