package piyushaman.oadproject.topquiz.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Summary panel to show score summary
 *
 */
public class SummaryPanel extends JPanel {

	// member controls
	private JLabel lblTotalScore;
	private JLabel lblAttempted;
	private JLabel lblCorrect;
	private JLabel lblThank;
	private JLabel lblInfo;

	private JButton btnPlayAgain;
	private JPanel playAgainPane;

	// score statistics collection
	private Map<String, Double> statistics = new HashMap<String, Double>(); // <SUBJECT,SCORE_PERCENT>

	// Constructor
	/**
	 * Creates score summary panel
	 *
	 * @param summary
	 */
	public SummaryPanel(ScoreSummary summary) {
		statistics = summary.getStatistics();

		setBackground(new Color(239, 114, 115)); // set background color
		setLayout(new BorderLayout());

		lblThank = new JLabel("<html>QUIZ STATS<br/></html>", SwingConstants.CENTER);
		lblTotalScore = new JLabel("Your score: " + summary.getTotalScore());
		lblAttempted = new JLabel("Number of questions attempted: " + summary.getTotalQuestions());
		lblCorrect = new JLabel("Number of correct answers: " + summary.getCorrectAnswers());
		lblInfo = new JLabel();

		lblThank.setFont(new Font("Sans Serif", Font.BOLD, 25)); // set font
		lblThank.setForeground(new Color(255, 255, 255)); // set font color
		lblTotalScore.setFont(new Font("Sans Serif", Font.BOLD, 20));
		lblTotalScore.setForeground(new Color(255, 255, 255));
		lblAttempted.setFont(new Font("Sans Serif", Font.BOLD, 20));
		lblAttempted.setForeground(new Color(255, 255, 255));
		lblCorrect.setFont(new Font("Sans Serif", Font.BOLD, 20));
		lblCorrect.setForeground(new Color(255, 255, 255));
		lblInfo.setFont(new Font("Sans Serif", Font.BOLD, 20));
		lblInfo.setForeground(new Color(255, 255, 255));

		// set info text
		// bar chart is created only if the user has a non-zero score
		if (summary.getTotalScore() == 0) {
			lblInfo.setText("<html>Your score is too low.<br/>Better luck next time!</html>");
			lblInfo.setForeground(new Color(255, 255, 255));
		}

		// create score pane

		JPanel finalScorePane = new JPanel();
		finalScorePane.setLayout(new BoxLayout(finalScorePane, BoxLayout.Y_AXIS));
		finalScorePane.setPreferredSize(new Dimension(500, 200));
		finalScorePane.setBackground(new Color(239, 114, 115)); //
		
		
		finalScorePane.add(lblThank);
		finalScorePane.add(lblTotalScore);
		finalScorePane.add(lblAttempted);
		finalScorePane.add(lblCorrect);
		
		finalScorePane.add(lblInfo);
		
		//graph pane
		JPanel graphPane=new JPanel();
		graphPane.setLayout(new BorderLayout());
		graphPane.setAlignmentX(CENTER_ALIGNMENT);
		graphPane.setPreferredSize(new Dimension(600,350));
		
		

		//add to layout
		
		add(finalScorePane,BorderLayout.NORTH);

		
		
		//play again option
		playAgainPane=new JPanel();
		playAgainPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnPlayAgain=new JButton("Replay");
		btnPlayAgain.setIcon(new ImageIcon("./Resources/LayoutImages/routeReplay.png"));
		btnPlayAgain.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPlayAgain.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPlayAgain.setBorderPainted(false);
		btnPlayAgain.setContentAreaFilled(false);
		btnPlayAgain.setFont(new Font("Calibri", Font.BOLD, 15));
		btnPlayAgain.setForeground(new Color(0, 0, 139));
		btnPlayAgain.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// start over again
				if (e.getSource() == btnPlayAgain) {

				    Frame[] fr=JFrame.getFrames();
				    for(Frame f:fr)
				    {
				    	f.dispose();
				    }
				    new TopQuizFrame();
				}
				
			}
		});
		playAgainPane.add(btnPlayAgain);
		//show Try again button
    	playAgainPane.setVisible(true);
    	add(playAgainPane,BorderLayout.SOUTH);//add to layout
    	
		
	}
}
	



