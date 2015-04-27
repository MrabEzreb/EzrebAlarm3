package com.ezrebclan.ezrebalarm;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.ezrebclan.ezrebalarm.xml.PopupDesigner;
import com.ezrebclan.ezrebalarm.xml.XMLDOM;

public class TaskbarIcon {
	
	private static final TrayIcon trayIcon =
			new TrayIcon(createImage("res/tray.png", "EzrebAlarm 3 Tray Icon"));

	public static void init() {
		if (!SystemTray.isSupported()) {
		    System.out.println("SystemTray is not supported");
		    return;
		}
		final SystemTray tray = SystemTray.getSystemTray();
		final PopupMenu popup = new PopupMenu();
		
		// Create a pop-up menu components
		Menu menuNew = new Menu("New...");
		MenuItem newPopupAlert = new MenuItem("...Popup Alert");
		MenuItem exit = new MenuItem("Exit EzrebAlarm");
		
		//Add actionlisteners to components
		exit.addActionListener(exitListener);
		
		//Add components to sub-menus
		menuNew.add(newPopupAlert);
		newPopupAlert.addActionListener(newPopupAlertListener);
		
		//Add components to pop-up menu
		popup.add(menuNew);
		popup.addSeparator();
		popup.add(exit);
		
		trayIcon.setPopupMenu(popup);
		trayIcon.setImageAutoSize(true);
		trayIcon.setToolTip("EzrebAlarm3 (Dev)");
		trayIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1) {
					try {
						URI url = new URI("https://github.com/MrabEzreb/EzrebAlarm3");
						Desktop.getDesktop().browse(url);
					} catch (URISyntaxException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		       
		try {
		    tray.add(trayIcon);
		} catch (AWTException e) {
		    System.out.println("TrayIcon could not be added.");
		}
	}
	
	public static void exit() {
		SystemTray.getSystemTray().remove(trayIcon);
	}
	
	//Actionlisteners
	private static ActionListener exitListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			Main.stop();
		}
	};
	private static ActionListener newPopupAlertListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			PopupDesigner pd = new PopupDesigner();
			Element popup = pd.waitForDone();
			new File("data/popupWindows").mkdirs();
			File xml = new File("data/popupWindows/"+pd.getTxtFileName().getText()+".xml");
			try {
				xml.createNewFile();
			} catch (IOException e3) {
				e3.printStackTrace();
			}
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(xml));
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			Document doc = null;
			try {
				doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			} catch (ParserConfigurationException e1) {
				e1.printStackTrace();
			}
			doc.appendChild(doc.createElement("document"));
			doc.getDocumentElement().appendChild(doc.importNode(popup, true));
			try {
				bw.write(XMLDOM.getString(doc));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				bw.flush();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			try {
				bw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	};
	
	
	
	
	private static Image createImage(String path, String description) {
		URL imageURL = TaskbarIcon.class.getClassLoader().getResource(path);
		if (imageURL == null) {
			System.err.println("Resource not found: " + path);
			return null;
		} else {
			return (new ImageIcon(imageURL, description)).getImage();
		}
	}
}
