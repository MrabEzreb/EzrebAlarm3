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
    doc.appendChild(toXML())
    fw.write(XMLDOM.toString(doc))
    fw.flush()
    fw.close()
  }
}