package com.CompactCalculators;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame {
	private static JFrame frame;
	private ToolBar toolBar;
	private TextPanel textPanel;
	private CalculatorsPanel calcPanel;

	public MainFrame() {
		
		frame = new JFrame("Compact Calculators");
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setSize(800, 700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		

		toolBar = new ToolBar();
		calcPanel = new CalculatorsPanel();
		textPanel = new TextPanel();

		toolBar.setStringListener(new StringListener() {
			public void textEmitted(String text) {
				// textPanel.appendText(text);
			}
		});
		calcPanel.setCalcListener(new CalculatorsListener() {
			public void calcEventOccurred(CalculatorsEvent e) {
			}
		});

		frame.add(toolBar, BorderLayout.NORTH);
		frame.add(calcPanel, BorderLayout.WEST);
	
		
	}
	public static JFrame getMainFrame() {
		return frame;
	}

}