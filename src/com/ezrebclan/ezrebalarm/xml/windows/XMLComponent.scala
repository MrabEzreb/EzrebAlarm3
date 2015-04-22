package com.ezrebclan.ezrebalarm.xml.windows

import java.io.File
import org.w3c.dom.Element
import com.ezrebclan.ezrebalarm.xml.windows.components.XMLJLabel
import com.ezrebclan.ezrebalarm.xml.windows.components.attributes.HorizontalAlignment
import com.ezrebclan.ezrebalarm.xml.windows.components.attributes.VerticalAlignment
import javax.swing.ImageIcon
import javax.imageio.ImageIO
import java.awt.Font

trait XMLComponent {

  val dom: Element
  
  def create(window: XMLWindow): XMLWindow
}
object XMLComponent {
  
  def makeComponent(XMLData: Element): XMLComponent = {
    var typeOf = XMLData.getAttribute("type")
    var comp: XMLComponent = null
    typeOf match {
      case "label" => {
        comp = new XMLJLabel(XMLData.getAttribute("variable"))
        comp.asInstanceOf[XMLJLabel].displayedMnemonic = XMLData.getElementsByTagName("displayedMnemonic").item(0).getTextContent.toCharArray()(0)
        comp.asInstanceOf[XMLJLabel].horizontalAlignment = HorizontalAlignment.valueOf(XMLData.getElementsByTagName("horizontalAlignment").item(0).getTextContent)
        comp.asInstanceOf[XMLJLabel].verticalAlignment = VerticalAlignment.valueOf(XMLData.getElementsByTagName("verticalAlignment").item(0).getTextContent())
        comp.asInstanceOf[XMLJLabel].icon = new ImageIcon(ImageIO.read(new File(XMLData.getElementsByTagName("icon").item(0).getTextContent)))
        comp.asInstanceOf[XMLJLabel].labelForStr = XMLData.getElementsByTagName("labelFor").item(0).getTextContent
        comp.asInstanceOf[XMLJLabel].text = XMLData.getElementsByTagName("text").item(0).getTextContent
        comp.asInstanceOf[XMLJLabel].tooltipText = XMLData.getElementsByTagName("toolTipText").item(0).getTextContent
        comp.asInstanceOf[XMLJLabel].enabledBool = XMLData.getElementsByTagName("enabled").item(0).getTextContent.toBoolean
        comp.asInstanceOf[XMLJLabel].foregroundStr = XMLData.getElementsByTagName("foreground").item(0).getTextContent
        comp.asInstanceOf[XMLJLabel].backgroundStr = XMLData.getElementsByTagName("background").item(0).getTextContent
        comp.asInstanceOf[XMLJLabel].fontRaw = new Font(XMLData.getElementsByTagName("font").item(0).getTextContent, XMLData.getElementsByTagName("font").item(0).getAttributes.getNamedItem("size").getTextContent.toInt, 0)
      }
    }
    comp
  }
}