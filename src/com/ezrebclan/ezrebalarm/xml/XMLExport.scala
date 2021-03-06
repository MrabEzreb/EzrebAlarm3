package com.ezrebclan.ezrebalarm.xml

import org.w3c.dom.Element
import org.w3c.dom.Document
import java.io.FileWriter
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory

abstract trait XMLExport {

  def toXML(): Element
  
  def writeToFile(file: File): Unit = {
    var fw = new FileWriter(file)
    var doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument()
    doc.appendChild(doc.createElement("document"));
    doc.getDocumentElement.appendChild(toXML())
    fw.write(XMLDOM.getString(doc))
    fw.flush()
    fw.close()
  }
  
  def getFromXML(element: Element): Unit
}