package com.ezrebclan.ezrebalarm.xml;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.scene.canvas.GraphicsContext;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PopupAlert extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6054586640815563653L;
	private JPanel contentPane;
	private JLabel lblTitle;
	private JLabel lblSecondmessage;
	private JLabel lblMessage;
	private JButton btnClosebutton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopupAlert frame = new PopupAlert();
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
	public PopupAlert() {
		setSize(new Dimension(300, 300));
		this.setLocation(GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint().x-150, GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint().y-150);
		setUndecorated(true);
		setVisible(true);
		setResizable(false);
		setTitle("EzrebAlarm3");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		FlowLayout fl_contentPane = new FlowLayout(FlowLayout.CENTER, 300, 50);
		fl_contentPane.setAlignOnBaseline(true);
		contentPane.setLayout(fl_contentPane);
		
		lblTitle = new JLabel("Title");
		contentPane.add(lblTitle);
		
		lblMessage = new JLabel("Message");
		contentPane.add(lblMessage);
		
		lblSecondmessage = new JLabel("SecondMessage");
		contentPane.add(lblSecondmessage);
		
		btnClosebutton = new JButton("CloseButton");
		btnClosebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PopupAlert.this.dispose();
			}
		});
		contentPane.add(btnClosebutton);
	}

	public JLabel getLblTitle() {
		return lblTitle;
	}
	public JLabel getLblSecondmessage() {
		return lblSecondmessage;
	}
	public JLabel getLblMessage() {
		return lblMessage;
	}
	public JButton getBtnClosebutton() {
		return btnClosebutton;
	}
}
