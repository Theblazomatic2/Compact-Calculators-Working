package com.CompactCalculators;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WagesCalculator extends JFrame implements ActionListener {
	private ToolBar toolbar;
	// --------------------------JButtons-------------------------------------------------//
	private JButton clearButton, enterButton;
	// --------------------------JFrames--------------------------------------------------//

	private JFrame frame = new JFrame("Wage Calculator");

	// --------------------------Dimensions-----------------------------------------------//

	private Dimension d, tf;

	// --------------------------JPanels--------------------------------------------------//

	private JPanel numbersPanel;
	private JPanel framePanel;

	// --------------------------JTextFields----------------------------------------------//

	private JTextField hoursTextField, hourlyPayField, overTimeHoursField, outputField;

	// --------------------------JLabels--------------------------------------------------//
	private JLabel hoursLabel, hourlyPayLabel, overTimeHoursLabel, outputLabel;
	// --------------------------Variables------------------------------------------------//
	double  totalPay, overTimePay, regPay;
	// --------------------------Scanners-------------------------------------------------//
	private Scanner scan;

	// -----------------------------------------------------------------------------------//
	public WagesCalculator() {
		toolbar = new ToolBar();
		enterButton = new JButton("Enter");
		clearButton = new JButton("Clear");
		framePanel = new JPanel();
		hoursTextField = new JTextField();
		hoursLabel = new JLabel("Hours: ");
		hourlyPayLabel = new JLabel("Hourly Wage: ");
		hourlyPayField = new JTextField();
		overTimeHoursLabel = new JLabel("Over Time Hours: ");
		overTimeHoursField = new JTextField();
		outputField = new JTextField();
		outputLabel = new JLabel("Output: ");
		
		enterButton.addActionListener(this);
		clearButton.addActionListener(this);
		
		d = new Dimension(600, 550);

		frame.setLayout(new BorderLayout());
		frame.setSize(d);
		frame.setLocationRelativeTo(null);
		frame.add(toolbar, BorderLayout.NORTH);

		framePanel.setLayout(new GridLayout(5, 2));
		frame.add(framePanel);
		//////////////////////////////////////////////////////////////////////////////////////////////////
		hoursLabel.setLayout(null);
		framePanel.add(hoursLabel);
		//////////////////////////////////////////////////////////////////////////////////////////////////
		hoursTextField.setLayout(null);
		framePanel.add(hoursTextField);
		//////////////////////////////////////////////////////////////////////////////////////////////////
		hourlyPayLabel.setLayout(null);
		framePanel.add(hourlyPayLabel);
		//////////////////////////////////////////////////////////////////////////////////////////////////
		hourlyPayField.setLayout(null);
		framePanel.add(hourlyPayField);
		//////////////////////////////////////////////////////////////////////////////////////////////////
		overTimeHoursLabel.setLayout(null);
		framePanel.add(overTimeHoursLabel);
		//////////////////////////////////////////////////////////////////////////////////////////////////
		overTimeHoursField.setLayout(null);
		framePanel.add(overTimeHoursField);
		//////////////////////////////////////////////////////////////////////////////////////////////////
		outputLabel.setLayout(null);
		framePanel.add(outputLabel);
		//////////////////////////////////////////////////////////////////////////////////////////////////
		outputField.setLayout(null);
		outputField.setEditable(false);
		framePanel.add(outputField);
		//////////////////////////////////////////////////////////////////////////////////////////////////
		enterButton.setFocusable(false);
		clearButton.setFocusable(false);

		framePanel.add(enterButton);
		framePanel.add(clearButton);

		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == enterButton) {
		String hourlyPayFieldValue = hourlyPayField.getText();
		double payPerHour = Double.parseDouble(hourlyPayFieldValue);
		
		String hoursAWeekFieldValue = hoursTextField.getText();
		double hoursAWeek = Double.parseDouble(hoursAWeekFieldValue);
		
		String overTimeHoursFieldvalue = overTimeHoursField.getText();
		double overTimeHours = Double.parseDouble(overTimeHoursFieldvalue);
		
			regPay = payPerHour * hoursAWeek;
			overTimePay = overTimeHours * (payPerHour * 1.5);

			totalPay = overTimePay + regPay;

			outputField.setText("Your Weekly Pay Is: " + totalPay);
		}
		if(e.getSource() == clearButton) {
			hourlyPayField.setText("");
			hoursTextField.setText("");
			overTimeHoursField.setText("");
			outputField.setText("");
		}
	}
}
