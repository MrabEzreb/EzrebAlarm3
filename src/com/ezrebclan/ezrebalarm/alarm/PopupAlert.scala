package com.ezrebclan.ezrebalarm.alarm

import scala.reflect.io.File
import com.ezrebclan.ezrebalarm.xml.PopupAlertIO

trait PopupAlert extends Alarm {

  hasPopupAlert = true
  override def goOff(): Unit = {
    var alert = PopupAlertIO.getPopupAlert(PopupAlertIO.getXML(popupDescriptor))
    alert.setVisible(true)
    super.goOff
  }
}