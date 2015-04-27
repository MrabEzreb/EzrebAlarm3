package com.ezrebclan.ezrebalarm.dataTypes

import java.util.Calendar
import com.ezrebclan.ezrebalarm.xml.XMLExport
import com.ezrebclan.ezrebalarm.xml.XMLExport
import org.w3c.dom.Element
import com.sun.org.apache.xerces.internal.impl.xs.opti.DefaultElement
import org.w3c.dom.Document
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
/**
 * This class takes a hour (24-hour time, not 12-hour), a minute, and a second, and makes a Time object from that.
 */
class Time(hours: Int, minutes: Int, seconds: Int) extends BaseData with XMLExport {

  var hour: Int = hours
  var minute: Int = minutes
  var second: Int = seconds
  
  def isNow(): Boolean = {
    if(Time.getNow().equals(this)) {
      true
    } else {
      false
    }
  }
  override def toXML(): Element = {
    var parent = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument()
    parent.appendChild(parent.createElement("document"))
    var time = parent.createElement("time")
    time.setAttribute("hour", hour.toString())
    time.setAttribute("minute", minute.toString())
    time.setAttribute("second", second.toString())
    time.setTextContent(toString())
    parent.getDocumentElement.appendChild(time)
    parent.getDocumentElement
  }
  override def getFromXML(element: Element): Unit = {
    hour = element.getAttribute("hour").toInt
    minute = element.getAttribute("minute").toInt
    second = element.getAttribute("second").toInt
  }
  override def toString(): String = {
    hour+":"+minute+":"+second
  }
  override def equals(arg0: Any): Boolean = {
    var retVal = false
    if(arg0.isInstanceOf[Time]) {
      var arg1: Time = arg0.asInstanceOf[Time]
      if(arg1.hour == hour &&(arg1.minute == minute &&(arg1.second == second))) {
        retVal = true
      }
    }
    retVal
  }
}
object Time {
  def getNow(): Time = {
    var cal = Calendar.getInstance
    var hour = cal.get(Calendar.HOUR_OF_DAY)
    var minute = cal.get(Calendar.MINUTE)
    var second = cal.get(Calendar.SECOND)
    new Time(hour, minute, second)
  }
}