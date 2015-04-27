package com.ezrebclan.ezrebalarm.xml;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.Element;

public class PopupDesigner extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8312844179089899812L;
	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtMessage;
	private JTextField txtSecondMessage;
	private JTextField txtCloseButtonText;
	private JButton btnSave;
	private JTextField txtFileName;
	public Element e = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopupDesigner frame = new PopupDesigner();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PopupDesigner() {
		setSize(new Dimension(300, 300));
		setTitle("EzrebAlarm Popup Designer");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 25));
		
		txtTitle = new JTextField();
		txtTitle.setText("Title");
		contentPane.add(txtTitle);
		txtTitle.setColumns(25);
		
		txtMessage = new JTextField();
		txtMessage.setText("Message");
		contentPane.add(txtMessage);
		txtMessage.setColumns(25);
		
		txtSecondMessage = new JTextField();
		txtSecondMessage.setText("Second Message");
		contentPane.add(txtSecondMessage);
		txtSecondMessage.setColumns(25);
		
		txtCloseButtonText = new JTextField();
		txtCloseButtonText.setText("Close Button Text");
		contentPane.add(txtCloseButtonText);
		txtCloseButtonText.setColumns(25);
		
		txtFileName = new JTextField();
		txtFileName.setHorizontalAlignment(SwingConstants.CENTER);
		txtFileName.setText("Name");
		contentPane.add(txtFileName);
		txtFileName.setColumns(10);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PopupAlert pa = new PopupAlert();
				pa.setVisible(false);
				pa.getLblTitle().setText(txtTitle.getText());
				pa.getLblMessage().setText(txtMessage.getText());
				pa.getLblSecondmessage().setText(txtSecondMessage.getText());
				pa.getBtnClosebutton().setText(txtCloseButtonText.getText());
				Element e = PopupAlertIO.getXML(pa);
				pa.dispose();
				PopupDesigner.this.e = e;
			}
		});
		contentPane.add(btnSave);
	}
	
	public Thread waitForDone() {
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(e == null) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		return t;
	}

	public JTextField getTxtFileName() {
		return txtFileName;
	}
}
