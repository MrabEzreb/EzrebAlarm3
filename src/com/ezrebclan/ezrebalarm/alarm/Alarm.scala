package com.ezrebclan.ezrebalarm.alarm

import com.ezrebclan.ezrebalarm.dataTypes.Time
import javax.sound.sampled.AudioSystem
import java.io.File

class Alarm(alarmTime: Time) {

  var time: Time = alarmTime
  def goOff(): Unit = {
    println("test")
  }
  //Trait variables
  //SoundAlert
  var hasSoundAlert = false
  var audioFile: File = null
  //PopupAlert
  var hasPopupAlert = false
  var popupDescriptor: File = null
}