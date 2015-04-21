package com.ezrebclan.ezrebalarm.alarm

trait PopupAlert extends Alarm {

  hasPopupAlert = true
  override def goOff(): Unit = {
    println("test3")
    super.goOff
  }
}