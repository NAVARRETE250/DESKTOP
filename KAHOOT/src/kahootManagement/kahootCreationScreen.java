package kahootManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.stream.IntStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import errorHandling.*;

public class kahootCreationScreen extends JFrame {

	private JPanel contentPane;
	private JTextField titleField;
	private JTextField questionField;
	private JTextField answerFieldA;
	private JTextField answerFieldB;
	private JTextField answerFieldC;
	private JTextField answerFieldD;
	private JList questionList;
	private ArrayList<KahootQuestion> questions = new ArrayList<KahootQuestion>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kahootCreationScreen frame = new kahootCreationScreen();
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
	public kahootCreationScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 379);
		setTitle("Create Kahoot");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Title");
		
		titleField = new JTextField();
		titleField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Questions");
		
		JLabel lblNewLabel_2 = new JLabel("Related tags");
		
		JLabel lblNewLabel_3 = new JLabel("New question");
		
		JLabel lblNewLabel_4 = new JLabel("Answers");
		
		JLabel lblNewLabel_5 = new JLabel("Right answers");
		
		JButton btnAddQuestion = new JButton("Add question");
		
		JButton btnSaveKahoot = new JButton("Save new kahoot");
		
		JScrollPane newQuestionScrollPane = new JScrollPane();
		
		JScrollPane questionScrollPane = new JScrollPane();
		
		JScrollPane tagScrollPane = new JScrollPane();
		
		JCheckBox chckbxA = new JCheckBox("");
		
		JCheckBox chckbxB = new JCheckBox("");
		
		JCheckBox chckbxC = new JCheckBox("");
		
		JCheckBox chckbxD = new JCheckBox("");
		

		JPanel answerPanel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(101)
							.addComponent(btnAddQuestion))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(titleField, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 236, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_1)
												.addComponent(lblNewLabel_3)
												.addComponent(questionScrollPane, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
											.addGap(66))
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
											.addComponent(newQuestionScrollPane, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
											.addGap(69)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(answerPanel, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(btnSaveKahoot)
												.addComponent(lblNewLabel_4))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
													.addComponent(tagScrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
													.addComponent(lblNewLabel_2, Alignment.LEADING))
												.addGap(13))))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxA)
								.addComponent(lblNewLabel_5)
								.addComponent(chckbxB, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxC, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxD, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addGap(69)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(titleField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(tagScrollPane, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addComponent(questionScrollPane, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_5))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(chckbxA)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxB, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxC, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxD, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(38))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(newQuestionScrollPane, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(answerPanel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAddQuestion)
								.addComponent(btnSaveKahoot)))))
		);
		answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.Y_AXIS));
		
		answerFieldA = new JTextField();
		answerPanel.add(answerFieldA);
		answerFieldA.setColumns(10);
		
		answerFieldB = new JTextField();
		answerPanel.add(answerFieldB);
		answerFieldB.setColumns(10);
		
		answerFieldC = new JTextField();
		answerPanel.add(answerFieldC);
		answerFieldC.setColumns(10);
		
		answerFieldD = new JTextField();
		answerPanel.add(answerFieldD);
		answerFieldD.setColumns(10);
		
		questionField = new JTextField();
		newQuestionScrollPane.setViewportView(questionField);
		questionField.setColumns(10);
		
		JList tagList = new JList();
		tagScrollPane.setViewportView(tagList);
		
		questionList = new JList();
		questionList.setModel(new AbstractListModel() {
			String[] values = new String[] {"nothing at all"};
			
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		questionScrollPane.setViewportView(questionList);
		contentPane.setLayout(gl_contentPane);
		
		chckbxA.addActionListener((ActionListener) new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chckbxA.isSelected()) {
					chckbxB.setSelected(false);
					chckbxC.setSelected(false);
					chckbxD.setSelected(false);
				}
				
			}
		});
		
		chckbxB.addActionListener((ActionListener) new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if (chckbxB.isSelected()) {
							chckbxA.setSelected(false);
							chckbxC.setSelected(false);
							chckbxD.setSelected(false);
						}
						
					}
				});
		
		chckbxC.addActionListener((ActionListener) new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chckbxC.isSelected()) {
					chckbxA.setSelected(false);
					chckbxB.setSelected(false);
					chckbxD.setSelected(false);
				}
				
			}
		});
		
		chckbxD.addActionListener((ActionListener) new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chckbxD.isSelected()) {
					chckbxA.setSelected(false);
					chckbxB.setSelected(false);
					chckbxC.setSelected(false);
				}
				
			}
		});
		
		btnAddQuestion.addActionListener((ActionListener) new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Hashtable<String, Boolean> answers = new Hashtable<String, Boolean>();
				answers.put(answerFieldA.getText(), chckbxA.isSelected());
				answers.put(answerFieldB.getText(), chckbxB.isSelected());
				answers.put(answerFieldC.getText(), chckbxC.isSelected());
				answers.put(answerFieldD.getText(), chckbxD.isSelected());
				Enumeration<String> answersEnum = answers.keys();
				
				int answerAmount = 0;
				boolean hasCorrect = false;
				//Check amount of answers and if there is a right answer
				try {
					while(answersEnum.hasMoreElements()) {
						String answer = answersEnum.nextElement();
						if (answer.length() > 0) {
							answerAmount++;
							if (answers.get(answer) == true) {
								hasCorrect = true;
							}
						}
					}

					if(questionField.getText().length() < 1)
						throw new CustomException("Please, enter a question");
					if(answerAmount < 2)
						throw new CustomException("This question needs more answers");
					if(hasCorrect == false)
						throw new CustomException("There needs to be a correct answer");
					
					//Add KahootQuestion to question list
					questions.add(new KahootQuestion(questionField.getText(), answers));
					
					//Reset Question list to display questions in panel
					String[] questionTexts = new String[questions.size()];
					for (int i = 0; i < questions.size(); i++ ){
						  questionTexts[i] = questions.get(i).getQuestionText();
						} 
					questionList = new JList(questionTexts);
					
					//Update panel viewport
					questionScrollPane.setViewportView(questionList);
					
					
					//	Reset everything					
					questionField.setText("");
					answerFieldA.setText("");
					answerFieldB.setText("");
					answerFieldC.setText("");
					answerFieldD.setText("");
					chckbxA.setSelected(false);
					chckbxB.setSelected(false);
					chckbxC.setSelected(false);
					chckbxD.setSelected(false);
					
					
					
					
				} catch(CustomException exception) {
					System.out.println(exception.getMessageToShow());
				}
				
				
				
				
				
				
			}
		});
	}
}
