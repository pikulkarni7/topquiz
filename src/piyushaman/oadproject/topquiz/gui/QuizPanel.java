package piyushaman.oadproject.topquiz.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 * Panel to display quiz after topic selection from welcome screen
 * @author Aman
 *
 */
public class QuizPanel extends JPanel {

	private QuestionPanel questionPane;
	private SummaryPanel summaryPane;

	private String quizSubject;

	//setter
	public void setQuizSubject(String quizSubject) {
		this.quizSubject = quizSubject;
	}

	/**
	 * Initialize values for first load
	 */
	private void initValues()
	{
		questionPane=null;
		summaryPane=null;
	}

	/**
	 * Create quiz panel.
	 */
	public QuizPanel(String subject) {
		initValues();

		setQuizSubject(subject);

		setPreferredSize(new Dimension(550,500));

		// Live score update panel
		JPanel liveScorePane = new JPanel();
		liveScorePane.setLayout(new BoxLayout(liveScorePane, BoxLayout.Y_AXIS));
		JLabel lblScore = new JLabel("Score: 0");
		lblScore.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblScore.setFont(new Font("Sans Serif", Font.BOLD, 25));
		lblScore.setForeground(new Color(32, 33, 121));
		liveScorePane.add(lblScore);

		// Question panel
		questionPane = new QuestionPanel(quizSubject);

		// Right panel with live score and summary
		JPanel rightPane = new JPanel();
		rightPane.setLayout(new BoxLayout(rightPane, BoxLayout.Y_AXIS));
		rightPane.add(liveScorePane);

		// Lower panel with question and right pane
		JPanel lowerPane = new JPanel();
		lowerPane.setLayout(new BoxLayout(lowerPane, BoxLayout.X_AXIS));
		lowerPane.add(rightPane);
		lowerPane.add(questionPane);

		// Add components to main panel
		add(lowerPane);

		// Score listener for live score update
		questionPane.setScoreListener(new ScoreListener() {
			@Override
			public void scoreUpdated(int score) {
				lblScore.setText("Score: " + score);
			}
		});

		// Summary listener for ending quiz
		questionPane.setSummaryListener(new SummaryListener() {
			@Override
			public void quizEnded(ScoreSummary summary) {
				summaryPane = new SummaryPanel(summary);
				add(summaryPane);
				lowerPane.setVisible(false);
			}
		});
	}
}