package com.CompactCalculators;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ToolBar extends JPanel implements ActionListener {
	
	private JButton fileButton;
	private JButton editButton;
	private JButton optionsButton;
	
	private StringListener textListener;
	public ToolBar() {

		setBorder(BorderFactory.createEtchedBorder());
		
		fileButton = new JButton("File");
		fileButton.setFocusable(false);
		editButton = new JButton("Edit");
		editButton.setFocusable(false);
		optionsButton = new JButton("Options");
		optionsButton.setFocusable(false);
		
		fileButton.addActionListener(this);
		editButton.addActionListener(this);
		optionsButton.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(fileButton);
		add(editButton);
		add(optionsButton);
		
		
	}
	public void setStringListener(StringListener listener) {
		this.textListener = listener;
	}

	public void actionPerformed(ActionEvent e) {

	}

}
