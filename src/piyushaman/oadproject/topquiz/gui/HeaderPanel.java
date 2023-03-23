/**
 * 
 */
package piyushaman.oadproject.topquiz.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;


import java.awt.SystemColor;
import java.awt.Rectangle;

/**
 * Title panel in frame
 * @author Priya
 * 
 */
public class HeaderPanel extends JPanel {

	private JLabel lblTitle;
	private JLabel lblSubTitle;
	
	/**
	 * Create the Title panel.
	 */
	public HeaderPanel() {

		setBackground(new Color(239, 146, 115));
		setLayout(new GridLayout(2,1));
		setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(220, 220, 220)));

		//set size
		setPreferredSize(new Dimension(800, 200));
		setMaximumSize(new Dimension(1200, 300));
		setAlignmentX(JComponent.CENTER_ALIGNMENT);

		lblTitle=new JLabel("TopQuiz",SwingConstants.CENTER);
		lblTitle.setToolTipText("TopQuiz");
		lblTitle.setForeground(new Color(254, 249, 248));
		lblTitle.setBackground(new Color(239, 146, 115));
		lblTitle.setFont(new Font("Montserrat", Font.BOLD, 80));

		lblSubTitle=new JLabel("Test Your Knowledge",SwingConstants.CENTER);
		lblSubTitle.setForeground(new Color(254, 249, 248));
		lblSubTitle.setBackground(new Color(239, 146, 115));
		lblSubTitle.setFont(new Font("Montserrat", Font.PLAIN, 30));

		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(239, 146, 115));
		titlePanel.add(lblTitle);

		JPanel subTitlePanel = new JPanel();
		subTitlePanel.setBackground(new Color(239, 146, 115));
		subTitlePanel.add(lblSubTitle);

		//add to layout
		add(titlePanel);
		add(subTitlePanel);
	}


}
