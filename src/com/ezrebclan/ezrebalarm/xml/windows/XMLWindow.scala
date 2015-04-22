package com.ezrebclan.ezrebalarm.xml.windows

import org.w3c.dom.Document
import com.ezrebclan.ezrebalarm.xml.XMLExport
import javax.swing.JFrame
import scala.collection.mutable.HashMap

/**
 * @author Mrab Ezreb
 */


class XMLWindow(xmlDocument: Document) extends JFrame with XMLExport {
  
  val dom = xmlDocument
  /**
   * A mapping of XMLComponents to their names
   */
  var componentMap = new HashMap[String, XMLComponent]
  /**
   * A mapping of XMLComponent's names to the names of their parents
   */
  var componentTree = new HashMap[String, String]
  
}