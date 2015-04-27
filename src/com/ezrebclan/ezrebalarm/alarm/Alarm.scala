package com.ezrebclan.ezrebalarm.alarm

import java.io.File
import org.w3c.dom.Element
import com.ezrebclan.ezrebalarm.dataTypes.Time
import com.ezrebclan.ezrebalarm.xml.XMLExport
import javax.xml.parsers.DocumentBuilderFactory
import com.ezrebclan.ezrebalarm.xml.PopupAlertIO
import org.junit.Test
import com.ezrebclan.ezrebalarm.xml.XMLDOM
import org.junit.Assert._ 

class Alarm(alarmTime: Time) extends XMLExport {

  var time: Time = alarmTime
  def goOff(): Unit = {
    println("test")
  }
  override def toXML(): Element = {
    var doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument
    doc.appendChild(doc.createElement("document"))
    var alarmNode = doc.createElement("alarm")
    alarmNode.appendChild(doc.importNode(time.toXML().getElementsByTagName("time").item(0), true))
    var audioF = doc.createElement("audioFile")
    audioF.setTextContent(audioFile.getPath)
    var popupF = doc.createElement("popup")
    popupF.setTextContent(popupDescriptor.getPath)
    alarmNode.appendChild(audioF)
    alarmNode.appendChild(popupF)
    alarmNode
  }
  
  override def getFromXML(element: Element): Unit = {
    time = new Time(0,0,0)
    time.getFromXML(element.getElementsByTagName("time").item(0).asInstanceOf[Element])
    audioFile = new File(element.getElementsByTagName("audioFile").item(0).asInstanceOf[Element].getTextContent)
    popupDescriptor = new File(element.getElementsByTagName("audioFile").item(0).asInstanceOf[Element].getTextContent)
  }
  
  //Trait variables
  //SoundAlert
  var hasSoundAlert = false
  var audioFile: File = new File("")
  //PopupAlert
  var hasPopupAlert = false
  var popupDescriptor: File = new File("")
}