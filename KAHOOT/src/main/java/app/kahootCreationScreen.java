package main.java.app;

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
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import main.java.errorHandling.*;
import main.java.hibernate.dao.KahootDao;
import main.java.hibernate.dao.PreguntaDao;
import main.java.hibernate.dao.RespuestaDao;
import main.java.hibernate.model.Kahoot;
import main.java.hibernate.model.Pregunta;
import main.java.hibernate.model.Respuesta;
import main.java.hibernate.model.Usuario;
import main.java.readXML.KahootConfiguration;

public class kahootCreationScreen extends JFrame {

	private JPanel contentPane;
	private JTextField titleField;
	private JTextField questionField;
	private JTextField answerFieldA;
	private JTextField answerFieldB;
	private JTextField answerFieldC;
	private JTextField answerFieldD;
	private JList questionList;
	private ArrayList<Pregunta> questions = new ArrayList<Pregunta>();
	private ArrayList<Respuesta> respuestasFinales = new ArrayList<Respuesta>();

	/**
	 * Create the frame.
	 */
	public kahootCreationScreen(final kahootManagerScreen kms, final JPanel kahootPanel, final JScrollPane kahootScrollPane, final KahootConfiguration config) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 532, 379);
		setTitle("Create Kahoot");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Title");

		titleField = new JTextField();
		titleField.setColumns(10);
		titleField.setText("");

		JLabel lblNewLabel_1 = new JLabel("Questions");

		JLabel lblNewLabel_2 = new JLabel("Related tags");

		JLabel lblNewLabel_3 = new JLabel("New question");

		JLabel lblNewLabel_4 = new JLabel("Answers");

		JLabel lblNewLabel_5 = new JLabel("Right answers");

		JButton btnAddQuestion = new JButton("Add question");

		JButton btnSaveKahoot = new JButton("Save new kahoot");

		JScrollPane newQuestionScrollPane = new JScrollPane();

		final JScrollPane questionScrollPane = new JScrollPane();

		JScrollPane tagScrollPane = new JScrollPane();

		final JCheckBox chckbxA = new JCheckBox("");

		final JCheckBox chckbxB = new JCheckBox("");

		final JCheckBox chckbxC = new JCheckBox("");

		final JCheckBox chckbxD = new JCheckBox("");


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
				ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
				if(!answerFieldA.getText().equals("")) {
					respuestas.add(new Respuesta(answerFieldA.getText(), chckbxA.isSelected()));
				}
				if(!answerFieldB.getText().equals("")) {
					respuestas.add(new Respuesta(answerFieldB.getText(), chckbxB.isSelected()));
				}
				if(!answerFieldC.getText().equals("")) {
					respuestas.add(new Respuesta(answerFieldC.getText(), chckbxC.isSelected()));
				}
				if(!answerFieldD.getText().equals("")) {
					respuestas.add(new Respuesta(answerFieldD.getText(), chckbxD.isSelected()));
				}

				int answerAmount = 0;
				boolean hasCorrect = false;
				//Check amount of answers and if there is a right answer
				try {
					for (Respuesta respuesta : respuestas) {
						if(respuesta.isCorrecto() == true) {
							hasCorrect = true;
							break;
						}
					}
						
					if(questionField.getText().length() < 1)
						throw new CustomException("Please, enter a question");
					if(respuestas.size() < 2)
						throw new CustomException("This question needs more answers");
					if(hasCorrect == false)
						throw new CustomException("There needs to be a correct answer");
					

					//Add KahootQuestion to question list
					Pregunta pregunta = new Pregunta(questionField.getText());
					questions.add(pregunta);
					for (Respuesta respuesta : respuestas) {
						respuesta.setId_pregunta(pregunta);
						respuestasFinales.add(respuesta);
					}

					//Reset Question list to display questions in panel
					String[] questionTexts = new String[questions.size()];
					for (int i = 0; i < questions.size(); i++ ){
						  questionTexts[i] = questions.get(i).getEnunciado();
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




				} catch(CustomException ce) {
					JOptionPane.showMessageDialog(null, ce.getMessageToShow(), "Aviso",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSaveKahoot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String titulo = titleField.getText();
					if(questions.size()==0) {
						throw new CustomException("El Kahoot debe tener al menos una pregunta");
					}
					if(titulo.equals("")) {
						throw new CustomException("El Kahoot debe tener titulo");
					}
					Usuario user = Pantalla_Login.user;
					KahootDao kd = new KahootDao();
					Kahoot kahoot = new Kahoot(titulo,"CATEGORIA",user);
					kd.saveKahoot(kahoot);
					
					PreguntaDao pd = new PreguntaDao();
					for (Pregunta pregunta : questions) {
						pregunta.setId_kahoot(kahoot);
						pd.savePregunta(pregunta);
					}
					
					RespuestaDao rd = new RespuestaDao();
					for (Respuesta respuesta : respuestasFinales) {
						rd.saveRespuesta(respuesta);
					}
					dispose();
					kms.setUpKahoots(kahootPanel, kahootScrollPane, config);
					
				}catch(CustomException ce) {
					JOptionPane.showMessageDialog(null, ce.getMessageToShow(), "Aviso",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
	}
}