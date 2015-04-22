package com.ezrebclan.ezrebalarm.xml.windows.components

import com.ezrebclan.ezrebalarm.xml.windows.XMLComponent
import org.w3c.dom.Element
import javax.swing.JLabel
import com.ezrebclan.ezrebalarm.xml.windows.components.attributes.HorizontalAlignment
import com.ezrebclan.ezrebalarm.xml.windows.components.attributes.VerticalAlignment
import javax.swing.ImageIcon
import java.awt.Font
import java.awt.Point
import java.awt.Dimension
import java.awt.Rectangle
import com.ezrebclan.ezrebalarm.xml.windows.XMLWindow
import com.ezrebclan.ezrebalarm.xml.windows.XMLWindow
import java.awt.Color
import com.sun.org.apache.xerces.internal.impl.xs.XMLSchemaException
import com.ezrebclan.ezrebalarm.xml.XMLWindowException

class XMLJLabel(variable: String) extends JLabel with XMLComponent {
  
  val variableName: String = variable
  var displayedMnemonic: Char
  var horizontalAlignment: HorizontalAlignment
  var verticalAlignment: VerticalAlignment
  var icon: ImageIcon
  var labelForStr: String
  var text: String
  var tooltipText: String
  var enabledBool: Boolean
  var backgroundStr: String
  var foregroundStr: String
  var fontRaw: Font
  var locationRaw: Point
  var sizeRaw: Dimension
  var boundsRaw: Rectangle
  
  def create(window: XMLWindow): XMLWindow = {
    setDisplayedMnemonic(displayedMnemonic)
    setHorizontalAlignment(horizontalAlignment.getValue())
    setVerticalAlignment(verticalAlignment.getValue())
    setIcon(icon)
    if(labelForStr.equals("(master)")) {
      window.componentTree.put("", variableName)
    } else {
      window.componentTree.put(labelForStr, variableName)
    }
    setText(text)
    setToolTipText(tooltipText)
    setEnabled(enabledBool)
    if(foregroundStr.substring(0, foregroundStr.indexOf(".")).equals("AWT")) {
      var fgColorStr = foregroundStr.substring(foregroundStr.indexOf(".")+1)
      var fgColor: Color = null
      fgColorStr match {
        case "BLACK" => {fgColor = Color.BLACK}
        case "BLUE" => {fgColor = Color.BLUE}
        case "CYAN" => {fgColor = Color.CYAN}
        case "DARK_GRAY" => {fgColor = Color.DARK_GRAY}
        case "GRAY" => {fgColor = Color.GRAY}
        case "GREEN" => {fgColor = Color.GREEN}
        case "LIGHT_GRAY" => {fgColor = Color.LIGHT_GRAY}
        case "MAGENTA" => {fgColor = Color.MAGENTA}
        case "ORANGE" => {fgColor = Color.ORANGE}
        case "PINK" => {fgColor = Color.PINK}
        case "RED" => {fgColor = Color.RED}
        case "WHITE" => {fgColor = Color.WHITE}
        case "YELLOW" => {fgColor = Color.YELLOW}
        case _ => {throw new XMLWindowException("Incorrect Color")}
      }
      setForeground(fgColor)
    } else {
      throw new XMLWindowException("Incorrect Color")
    }
    if(backgroundStr.substring(0, backgroundStr.indexOf(".")).equals("AWT")) {
      var bgColorStr = backgroundStr.substring(backgroundStr.indexOf(".")+1)
      var bgColor: Color = null
      bgColorStr match {
        case "BLACK" => {bgColor = Color.BLACK}
        case "BLUE" => {bgColor = Color.BLUE}
        case "CYAN" => {bgColor = Color.CYAN}
        case "DARK_GRAY" => {bgColor = Color.DARK_GRAY}
        case "GRAY" => {bgColor = Color.GRAY}
        case "GREEN" => {bgColor = Color.GREEN}
        case "LIGHT_GRAY" => {bgColor = Color.LIGHT_GRAY}
        case "MAGENTA" => {bgColor = Color.MAGENTA}
        case "ORANGE" => {bgColor = Color.ORANGE}
        case "PINK" => {bgColor = Color.PINK}
        case "RED" => {bgColor = Color.RED}
        case "WHITE" => {bgColor = Color.WHITE}
        case "YELLOW" => {bgColor = Color.YELLOW}
        case _ => {throw new XMLWindowException("Incorrect Color")}
      }
      setBackground(bgColor)
    } else {
      throw new XMLWindowException("Incorrect Color")
    }
    setFont(fontRaw)
    setLocation(locationRaw)
    setSize(sizeRaw)
    setBounds(boundsRaw)
    window.componentMap.put(variableName, this)
    window
  }
}