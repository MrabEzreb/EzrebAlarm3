import static org.junit.Assert.*;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.ezrebclan.ezrebalarm.xml.PopupAlert;
import com.ezrebclan.ezrebalarm.xml.PopupAlertIO;
import com.ezrebclan.ezrebalarm.xml.XMLDOM;


public class XMLTest {

	@Test
	public void PopupAlertIOTest() {
		PopupAlert pa = new PopupAlert();
		Document doc = null;
	    try {
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			doc.appendChild(doc.createElement("document"));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		doc.getDocumentElement().appendChild(doc.importNode(PopupAlertIO.getXML(pa), true));
		//System.out.println(XMLDOM.getString(doc));
		assertNotNull("getString == null", XMLDOM.getString(doc));
		Document doc2 = null;
		try {
			doc2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		PopupAlertIO.writeXML((Element) doc.getDocumentElement().getElementsByTagName("popupAlert").item(0), new File("popupAlertTest.xml"));
		assertNotNull("Error when reading written XML file", PopupAlertIO.getXML(new File("popupAlertTest.xml")));
		doc2.appendChild(doc2.createElement("document"));
		Element doce = doc2.getDocumentElement();
		assertNotNull("Could not append child to raw document for some random stupid dumb reason :P", doce);
		doce.appendChild(doc2.importNode(PopupAlertIO.getXML(new File("popupAlertTest.xml")), true));
		assertEquals("XML Incorrect", "<document>\r\n<popupAlert id=\"popupAlert\">\r\n<title>Title</title>\r\n<message>Message</message>\r\n<lastMessage>SecondMessage</lastMessage>\r\n<close>CloseButton</close>\r\n</popupAlert>\r\n</document>\r\n", XMLDOM.getString(doc2));
	}

}
