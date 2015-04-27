package com.ezrebclan.ezrebalarm

import com.ezrebclan.ezrebalarm.alarm.Alarm
import com.ezrebclan.ezrebalarm.alarm.PopupAlert
import com.ezrebclan.ezrebalarm.alarm.SoundAlert
import com.ezrebclan.ezrebalarm.dataTypes.Time
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.Mixer
import javax.sound.sampled.DataLine
import javax.sound.sampled.Clip
import javax.sound.sampled.LineUnavailableException
import java.io.File
import javax.sound.sampled.AudioInputStream
import java.io.FileInputStream
import com.ezrebclan.ezrebalarm.audio.AudioPlayer

object Main {
  
  def start(args: Array[String]): Unit = {
//    var time = new Time(10, 5, 45)
//    var now = Time.getNow()
//    var doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument()
//    var time2 = time.toXML()
//    var now2 = now.toXML()
//    var base = doc.createElement("EzrebAlarm")
//    base.setAttribute("Version", "3")
//    doc.appendChild(base)
//    base.appendChild(time2)
//    base.appendChild(now2)
//    println(XMLDOM.toString(doc))
//    val file = new File("test.xml")
//    XMLDOM.writeDOMToFile(doc, file)
//    val file2 = new File("test2.xml")
//    time.writeToFile(file2)
//    var ar = new AudioPlayer
//    ar.convertMp3(new File("test.mp3").toURL())
//    var a = new Alarm(new Time(5,5,5)) with SoundAlert with PopupAlert {
//      override def goOff(): Unit = {
//        println("test4")
//        super.goOff
//      }
//    }
//    a.goOff()
    TaskbarIcon.init()
  }
  
  def stop(): Unit = {
    TaskbarIcon.exit()
  }
}