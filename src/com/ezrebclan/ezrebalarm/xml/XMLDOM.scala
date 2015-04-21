package com.ezrebclan.ezrebalarm.xml

import java.io.File
import org.w3c.dom.Document
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.ParserConfigurationException
import org.xml.sax.SAXException
import java.io.IOException
import java.io.StringWriter
import javax.xml.transform.TransformerFactory
import javax.xml.transform.OutputKeys
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult
import java.io.FileWriter

object XMLDOM {

  def getDOMFromFile(file: File): Document = {
    var doc: Document = null
    try {
      var dBF = DocumentBuilderFactory.newInstance()
      var dB = dBF.newDocumentBuilder()
      doc = dB.parse(file)
    } catch {
      case pce: ParserConfigurationException => pce.printStackTrace()
      case se: SAXException => se.printStackTrace()
      case ioe: IOException => ioe.printStackTrace() 
    }
    doc
  }
  
  def writeDOMToFile(doc: Document, file: File): Unit = {
    var fw = new FileWriter(file)
    fw.write(toString(doc))
    fw.flush()
    fw.close()
  }
  
  def toString(doc: Document): String = {
    var retVal: String = null
    try {
      var sw = new StringWriter
      var tf = TransformerFactory.newInstance()
      var transformer = tf.newTransformer()
      transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
      transformer.setOutputProperty(OutputKeys.METHOD, "xml");
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
      transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
      transformer.transform(new DOMSource(doc), new StreamResult(sw))
      retVal = sw.toString()
    } catch {
      case e: Exception => e.printStackTrace()
    }
    retVal
  }
}