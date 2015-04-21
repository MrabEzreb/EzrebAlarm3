package com.ezrebclan.ezrebalarm

import com.ezrebclan.ezrebalarm.dataTypes.Time
import javax.xml.parsers.DocumentBuilderFactory
import com.ezrebclan.ezrebalarm.xml.XMLDOM
import java.io.File
import javax.sound.sampled.Port
import javax.sound.sampled.Clip
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.DataLine
import java.io.FileInputStream
import java.io.InputStream
import java.nio.file.Files
import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioFormat
import java.applet.AudioClip
import com.ezrebclan.ezrebalarm.alarm.Alarm
import com.ezrebclan.ezrebalarm.alarm.SoundAlert
import com.ezrebclan.ezrebalarm.alarm.PopupAlert

object Main extends App {

  override def main(args: Array[String]): Unit = {
    var time = new Time(10, 5, 45)
    var now = Time.getNow()
    var doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument()
    var time2 = time.toXML()
    var now2 = now.toXML()
    var base = doc.createElement("EzrebAlarm")
    base.setAttribute("Version", "3")
    doc.appendChild(base)
    base.appendChild(time2)
    base.appendChild(now2)
    println(XMLDOM.toString(doc))
    val file = new File("test.xml")
    XMLDOM.writeDOMToFile(doc, file)
    val file2 = new File("test2.xml")
    time.writeToFile(file2)
    var a = new Alarm(new Time(5,5,5)) with SoundAlert with PopupAlert {
      override def goOff(): Unit = {
        println("test4")
        super.goOff
      }
    }
    a.goOff()
  }
}