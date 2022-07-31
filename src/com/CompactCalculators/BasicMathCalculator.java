package com.CompactCalculators;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BasicMathCalculator extends JFrame implements ActionListener {

	private JPanel numPanel;
	private JPanel textFieldPanel;
	private JPanel clrDelButtonsPanel;
	private JFrame frame;

	private JTextField calculationField;

	private JButton[] numberButtons = new JButton[10];
	private JButton[] functionButtons = new JButton[9];
	private Font myFont;

	// private ArrayList<Double> numbersToCalc = new ArrayList <Double>();

///////////////////Operator Buttons////////////////////////////////////////////////////

	private JButton add = new JButton("+");
	private JButton subtract = new JButton("-");
	private JButton multiply = new JButton("*");
	private JButton divide = new JButton("/");
	private JButton equals = new JButton("=");
	private JButton remainder = new JButton("%");
	private JButton clrButton = new JButton("Clear");
	private JButton delButton = new JButton("Del");
	private JButton decimalButton = new JButton(".");

	GridBagLayout gLayout = new GridBagLayout();
	GridBagConstraints gc = new GridBagConstraints();

	double num1, num2, num3, num4, num5, result;
	char operator;

	public BasicMathCalculator() {

		Font myFont = new Font("Times New Roman", Font.BOLD, 12);

		functionButtons[0] = add;
		functionButtons[1] = subtract;
		functionButtons[2] = multiply;
		functionButtons[3] = divide;
		functionButtons[4] = equals;
		functionButtons[5] = remainder;
		functionButtons[6] = clrButton;
		functionButtons[7] = delButton;
		functionButtons[8] = decimalButton;

		for (int i = 0; i < 9; i++) {

			functionButtons[i].setFont(myFont);
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFocusable(false);
		}
		for (int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}

		clrDelButtonsPanel = new JPanel();
		clrDelButtonsPanel.setLayout(new GridLayout(1, 2, 1, 1));
		clrDelButtonsPanel.setPreferredSize(new Dimension(275, 50));
		clrDelButtonsPanel.add(delButton);
		clrDelButtonsPanel.add(clrButton);
		calculationField = new JTextField();

		numPanel = new JPanel();
		numPanel.setLayout(new GridLayout(4, 4, 1, 1));
		numPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		frame = new JFrame();
		frame.setLayout(gLayout);
		frame.setSize(300, 700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		textFieldPanel = new JPanel();
		textFieldPanel.setLayout(new BorderLayout());
		textFieldPanel.setPreferredSize(new Dimension(275, 100));
		textFieldPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		textFieldPanel.add(calculationField);

		gc.weightx = 1;
		gc.weighty = 0.3;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridheight = 1;
		gc.insets = new Insets(-35, 0, 0, 0);
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.CENTER;
		frame.add(clrDelButtonsPanel, gc);

		gc.weightx = 1;
		gc.weighty = 0.3;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridheight = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.CENTER;
		frame.add(textFieldPanel, gc);

		gc.weightx = 1;
		gc.weighty = 1;
		gc.gridx = 0;
		gc.gridy = 2;
		gc.gridheight = 1;
		gc.insets = new Insets(-80, 0, 0, 0);
		gc.ipadx = 100;
		gc.ipady = 300;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.CENTER;
		frame.add(numPanel, gc);

		numPanel.add(numberButtons[1]);
		numPanel.add(numberButtons[2]);
		numPanel.add(numberButtons[3]);
		numPanel.add(add);
		numPanel.add(numberButtons[4]);
		numPanel.add(numberButtons[5]);
		numPanel.add(numberButtons[6]);
		numPanel.add(subtract);
		numPanel.add(numberButtons[7]);
		numPanel.add(numberButtons[8]);
		numPanel.add(numberButtons[9]);
		numPanel.add(multiply);
		numPanel.add(decimalButton);
		numPanel.add(numberButtons[0]);
		numPanel.add(equals);
		numPanel.add(divide);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numberButtons[i]) {
				calculationField.setText(calculationField.getText().concat(String.valueOf(i)));
			}
		}
		if (e.getSource() == decimalButton) {
			calculationField.setText(calculationField.getText().concat("."));
		}
		if (e.getSource() == add) {
			num1 = Double.parseDouble(calculationField.getText());
			operator = '+';
			calculationField.setText("");
		}
		if (e.getSource() == subtract) {
			num1 = Double.parseDouble(calculationField.getText());
			operator = '-';
			calculationField.setText("");
		}
		if (e.getSource() == multiply) {
			num1 = Double.parseDouble(calculationField.getText());
			operator = '*';
			calculationField.setText("");
		}
		if (e.getSource() == divide) {
			num1 = Double.parseDouble(calculationField.getText());
			operator = '/';
			calculationField.setText("");
		}
		if (e.getSource() == equals) {
			num2 = Double.parseDouble(calculationField.getText());

			switch (operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			}
			calculationField.setText(String.valueOf(result));
			num1 = result;
		}
		if (e.getSource() == clrButton) {
			calculationField.setText("");
		}
		if (e.getSource() == delButton) {
			String string = calculationField.getText();
			calculationField.setText("");
			for (int i = 0; i < string.length() - 1; i++) {
				calculationField.setText(calculationField.getText() + string.charAt(i));
			}
		}
		if (e.getSource() == subtract) {
			double temp = Double.parseDouble(calculationField.getText());
			temp *= -1;
			calculationField.setText(String.valueOf(temp));
		}
	}
}