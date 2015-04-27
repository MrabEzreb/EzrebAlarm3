import javax.xml.parsers.ParserConfigurationException
import com.ezrebclan.ezrebalarm.alarm.Alarm
import com.ezrebclan.ezrebalarm.xml.XMLDOM
import org.junit.Test
import com.ezrebclan.ezrebalarm.dataTypes.Time
import org.w3c.dom.Document
import org.junit.Assert._
import javax.xml.parsers.DocumentBuilderFactory
import com.ezrebclan.ezrebalarm.alarm.PopupAlert
import java.io.File

class AlarmXMLTest {

  @Test
  def test(): Unit = {
    var alarmXML = new Alarm(new Time(3, 0, 1)) with PopupAlert {
      popupDescriptor = new File("data/popupWindows/2.xml")
    }.toXML();
    assertNotNull("To XML == null", alarmXML);
    var doc: Document = null;
    doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    doc.appendChild(doc.importNode(alarmXML, true));
    var alarm = new Alarm(new Time(0,0,0))
    assertNotNull("Alarm Init Produces Null", alarm)
    assertNotNull("AlarmXML Null", alarmXML)
    alarm.getFromXML(alarmXML)
    assertEquals(3, alarm.time.hour)
  }
}