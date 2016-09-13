package com.todomind.api.todoist

import com.sun.javafx.tk.Toolkit.Task

/**
  * Created by V-Lamp on 24/04/2016.
  */
case class Project(
                    userId: Int,
                    name: String,
                    color: Int,
                    isDeleted: Int,
                    collapsed: Int,
                    id: Int,
                    archivedDate: String,
                    itemOrder: Int,
                    indent: Int,
                    archivedTimestamp: Int,
                    shared: Boolean,
                    isArchived: Int
                  ) {
  var subProjects : List[Project] = List()
  var items: List[Item] = List()
}
case class Note(
                  isDeleted: Int,
                  isArchived: Int,
                  fileAttachment: String,
                  content: String,
                  postedUid: Int,
                  uidsToNotify: String,
                  itemId: Int,
                  projectId: Int,
                  id: Int,
                  posted: String
                )
case class Label(
                   itemOrder: Int,
                   isDeleted: Int,
                   name: String,
                   color: Int,
                   id: Int,
                   uid: Int
                 )

case class Features(
                     goldTheme: Boolean
                   )
case class User(
                 restriction: Int,
                 startPage: String,
                 features: Features,
                 avatarSmall: String,
                 completedToday: Int,
                 isPremium: Boolean,
                 sortOrder: Int,
                 fullName: String,
                 autoReminder: Int,
                 timezone: String,
                 avatarS640: String,
                 joinDate: String,
                 id: Int,
                 nextWeek: Int,
                 completedCount: Int,
                 tzOffset: String,
                 theme: Int,
                 avatarMedium: String,
                 email: String,
                 startDay: Int,
                 avatarBig: String,
                 dateFormat: Int,
                 inboxProject: Int,
                 timeFormat: Int,
                 imageId: String,
                 beta: Int,
                 karmaTrend: String,
                 businessAccountId: String,
                 mobileNumber: String,
                 mobileHost: String,
                 hasPushReminders: Boolean,
                 isDummy: Int,
                 premiumUntil: String,
                 guideMode: Boolean,
                 token: String,
                 karma: Int,
                 isBizAdmin: Boolean,
                 defaultReminder: String,
                 dateistInlineDisabled: Boolean
               )
case class Filter(
                    userId: Int,
                    name: String,
                    color: Int,
                    itemOrder: Int,
                    query: String,
                    isDeleted: Int,
                    id: Int
                  )
case class Item(
                  dueDate: String,
                  dayOrder: Double,
                  assignedByUid: String,
                  dueDateUtc: String,
                  isArchived: Double,
                  labels: List[Double],
                  syncId: String,
                  inHistory: Double,
                  dateAdded: String,
                  checked: Double,
                  dateLang: String,
                  id: Double,
                  content: String,
                  indent: Double,
                  userId: Double,
                  isDeleted: Double,
                  priority: Double,
                  itemOrder: Double,
                  responsibleUid: String,
                  projectId: Double,
                  collapsed: Double,
                  dateString: String
                ) {
  var subItems: List[Item] = List()
  var project: Project = null
  var parentTask: Option[Task] = None
}


