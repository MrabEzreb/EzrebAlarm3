package com.ezrebclan.ezrebalarm.xml

import scala.reflect.io.File
import org.w3c.dom.Document
import org.w3c.dom.Element
import javax.xml.parsers.DocumentBuilderFactory
import org.w3c.dom.Text

object PopupAlertIO {

  def getPopupAlert(dom: Element): PopupAlert = {
    var alert = new PopupAlert
    var title = dom.getElementsByTagName("title")
    var mes1 = dom.getElementsByTagName("message")
    var mes2 = dom.getElementsByTagName("lastMessage")
    var close = dom.getElementsByTagName("close")
    alert.getLblTitle.setText(title.item(0).getTextContent)
    alert.getLblTitle.setText(mes1.item(0).getTextContent)
    alert.getLblTitle.setText(mes2.item(0).getTextContent)
    alert.getBtnClosebutton.setText(close.item(0).getTextContent)
    alert
  }
  def getXML(alert: PopupAlert): Element = {
    var doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument()
    var retVal = doc.createElement("popupAlert")
    retVal.setAttribute("id", "popupAlert")
    var title = doc.createElement("title")
    var mes1 = doc.createElement("message")
    var mes2 = doc.createElement("lastMessage")
    var close = doc.createElement("close")
    title.setTextContent(alert.getLblTitle.getText)
    mes1.setTextContent(alert.getLblMessage.getText)
    mes2.setTextContent(alert.getLblSecondmessage.getText)
    close.setTextContent(alert.getBtnClosebutton.getText)
    retVal.appendChild(title)
    retVal.appendChild(mes1)
    retVal.appendChild(mes2)
    retVal.appendChild(close)
    retVal
  }
  def writeXML(element: Element, xmlFile: java.io.File): Unit = {
    var file = new File(xmlFile)
    var bw = file.bufferedWriter()
    var doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    var root = doc.createElement("document")
    doc.appendChild(root);
    root.appendChild(doc.importNode(element, true))
    bw.write(XMLDOM.getString(doc))
    bw.flush()
    bw.close()
  }
  def getXML(xmlFile: java.io.File): Element = {
    var file = new File(xmlFile)
    var doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file.inputStream());
    doc.getDocumentElement.getElementsByTagName("popupAlert").item(0).asInstanceOf[Element]
  }
}