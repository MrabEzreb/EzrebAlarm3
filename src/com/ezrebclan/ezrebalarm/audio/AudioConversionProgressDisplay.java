package com.ezrebclan.ezrebalarm.audio;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class AudioConversionProgressDisplay extends JFrame {

	private JPanel contentPane;
	private JPanel progressPanel;
	private JButton btnFinish;
	private JProgressBar loadingFileBar;
	private JProgressBar convertingFileBar;
	private JProgressBar importingFileBar;
	private JProgressBar totalFileBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AudioConversionProgressDisplay frame = new AudioConversionProgressDisplay();
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
	public AudioConversionProgressDisplay() {
		setTitle("Audio Conversion Progress GUI");
		setMaximumSize(new Dimension(1920, 1080));
		setMinimumSize(new Dimension(250, 150));
		setSize(new Dimension(500, 300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainButtonPanel = new JPanel();
		mainButtonPanel.setLocation(new Point(5, 225));
		mainButtonPanel.setSize(new Dimension(475, 30));
		mainButtonPanel.setPreferredSize(new Dimension(475, 30));
		mainButtonPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.add(mainButtonPanel);
		FlowLayout fl_mainButtonPanel = new FlowLayout(FlowLayout.RIGHT, 10, 2);
		fl_mainButtonPanel.setAlignOnBaseline(true);
		mainButtonPanel.setLayout(fl_mainButtonPanel);
		
		btnFinish = new JButton("Finish");
		btnFinish.setEnabled(false);
		mainButtonPanel.add(btnFinish);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCancel.setPreferredSize(new Dimension(65, 24));
		btnCancel.setMinimumSize(new Dimension(65, 24));
		btnCancel.setMaximumSize(new Dimension(65, 24));
		mainButtonPanel.add(btnCancel);
		
		progressPanel = new JPanel();
		progressPanel.setLocation(new Point(5, 15));
		progressPanel.setSize(new Dimension(475, 200));
		progressPanel.setPreferredSize(new Dimension(450, 200));
		contentPane.add(progressPanel);
		GridBagLayout gbl_progressPanel = new GridBagLayout();
		gbl_progressPanel.columnWidths = new int[] {50, 350, 50};
		gbl_progressPanel.rowHeights = new int[] {25, 25, 25, 25, 25, 25, 25};
		gbl_progressPanel.columnWeights = new double[]{};
		gbl_progressPanel.rowWeights = new double[]{0.0};
		progressPanel.setLayout(gbl_progressPanel);
		
		loadingFileBar = new JProgressBar();
		loadingFileBar.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Loading File", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_loadingFileBar = new GridBagConstraints();
		gbc_loadingFileBar.fill = GridBagConstraints.BOTH;
		gbc_loadingFileBar.insets = new Insets(0, 0, 5, 5);
		gbc_loadingFileBar.gridx = 1;
		gbc_loadingFileBar.gridy = 1;
		progressPanel.add(loadingFileBar, gbc_loadingFileBar);
		
		convertingFileBar = new JProgressBar();
		convertingFileBar.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Converting File", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_convertingFileBar = new GridBagConstraints();
		gbc_convertingFileBar.fill = GridBagConstraints.BOTH;
		gbc_convertingFileBar.insets = new Insets(0, 0, 5, 5);
		gbc_convertingFileBar.gridx = 1;
		gbc_convertingFileBar.gridy = 2;
		progressPanel.add(convertingFileBar, gbc_convertingFileBar);
		
		importingFileBar = new JProgressBar();
		importingFileBar.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Importing File", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_importingFileBar = new GridBagConstraints();
		gbc_importingFileBar.fill = GridBagConstraints.BOTH;
		gbc_importingFileBar.insets = new Insets(0, 0, 5, 5);
		gbc_importingFileBar.gridx = 1;
		gbc_importingFileBar.gridy = 3;
		progressPanel.add(importingFileBar, gbc_importingFileBar);
		
		totalFileBar = new JProgressBar();
		totalFileBar.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Total Progress", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_totalFileBar = new GridBagConstraints();
		gbc_totalFileBar.fill = GridBagConstraints.BOTH;
		gbc_totalFileBar.insets = new Insets(0, 0, 5, 5);
		gbc_totalFileBar.gridx = 1;
		gbc_totalFileBar.gridy = 5;
		progressPanel.add(totalFileBar, gbc_totalFileBar);
	}

	public JPanel getProgressPanel() {
		return progressPanel;
	}
	public JButton getBtnFinish() {
		return btnFinish;
	}
	public JProgressBar getObtainingFileBar() {
		return loadingFileBar;
	}
	public JProgressBar getConvertingFileBar() {
		return convertingFileBar;
	}
	public JProgressBar getImportingFileBar() {
		return importingFileBar;
	}
	public JProgressBar getTotalFileBar() {
		return totalFileBar;
	}
	public void updateProgress(JProgressBar bar, int total, int current) {
		bar.setMaximum(total);
		bar.setMinimum(0);
		bar.setValue(current);
		int totalTotal = loadingFileBar.getMaximum()+convertingFileBar.getMaximum()+importingFileBar.getMaximum();
		int totalCurrent = loadingFileBar.getValue()+convertingFileBar.getValue()+importingFileBar.getValue();
		totalFileBar.setMinimum(0);
		totalFileBar.setMaximum(4);
		if(total == current) {
			totalFileBar.setValue(totalFileBar.getValue()+1);
		}
		if(totalCurrent == totalTotal) {
			btnFinish.setEnabled(true);
			btnFinish.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					AudioConversionProgressDisplay.this.dispose();
				}
			});
		}
	}
}
