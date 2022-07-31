package com.CompactCalculators;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class CalculatorsPanel extends JPanel {

	private JButton basicCalc;
	private JButton wageCalc;

	private CalculatorsListener calculatorsListener;
	private MainFrame dis;

	public CalculatorsPanel() {

		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		wageCalc = new JButton("Wage Calculator");
		wageCalc.setFocusable(false);
		wageCalc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(wageCalc)) {

				dis.getMainFrame().dispose();
				new WagesCalculator();
			}
		}
	});
		basicCalc = new JButton("Basic Math Calculator");
		basicCalc.setFocusable(false);
		basicCalc.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(basicCalc)) {

					dis.getMainFrame().dispose();
					new BasicMathCalculator();
				}
				
			}
		});
		Border innerBorder = BorderFactory.createTitledBorder("Calculator");
		Border outterBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outterBorder, innerBorder));

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
//   	gc.insets = new Insets(0, 0, 0, 0);
		add(basicCalc, gc);

		gc.weightx = 1;
		gc.weighty = 2;

		gc.gridx = 0;
		gc.gridy = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
//		gc.insets = new Insets(0, 0, 0, 0);
		add(wageCalc, gc);
	}

	public void setCalcListener(CalculatorsListener listener) {
		this.calculatorsListener = listener;
	}
}