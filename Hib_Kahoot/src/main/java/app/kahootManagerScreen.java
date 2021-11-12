package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class kahootManagerScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kahootManagerScreen frame = new kahootManagerScreen();
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
	public kahootManagerScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Kahoot Manager");
		setLocationRelativeTo(null);
		
		JLabel lblKahoots = new JLabel("Kahoots");
		
		JScrollPane kahootScrollPane = new JScrollPane();
		
		JScrollPane themeScrollPane = new JScrollPane();
		
		JLabel lblThemes = new JLabel("Temes");
		
		JButton btnDetails = new JButton("Veure Detall");
		
		JButton btnCreateKahoot = new JButton("Crear Kahoot");
		
		JButton btnPlay = new JButton("JUGAR");
		
		JButton btnFilterByTheme = new JButton("Filtrar per Tema");
		
		JButton btnEditThemes = new JButton("Editar Temes");
		
		JScrollPane selectedThemescrollPane = new JScrollPane();
		
		JLabel lblTemesSeleccionats = new JLabel("Temes seleccionats");
		
		JButton btnSelectTheme = new JButton("Seleccionar Tema");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnDetails)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnCreateKahoot, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblKahoots, Alignment.LEADING)
								.addComponent(kahootScrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnPlay)
							.addGap(68)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addComponent(lblThemes, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(themeScrollPane, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
								.addComponent(btnEditThemes, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
								.addComponent(btnFilterByTheme, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
								.addComponent(selectedThemescrollPane, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
								.addComponent(lblTemesSeleccionats, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
								.addComponent(btnSelectTheme, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
							.addGap(121)))
					.addGap(49))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKahoots)
						.addComponent(lblThemes))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(kahootScrollPane, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(themeScrollPane, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(btnSelectTheme)
							.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
							.addComponent(lblTemesSeleccionats)
							.addGap(31)))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCreateKahoot)
						.addComponent(btnDetails))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(btnFilterByTheme)
							.addGap(18)
							.addComponent(btnEditThemes, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(btnPlay)))
					.addGap(58))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(181, Short.MAX_VALUE)
					.addComponent(selectedThemescrollPane, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(128))
		);
		
		JList selectedThemeList = new JList();
		selectedThemescrollPane.setViewportView(selectedThemeList);
		
		JList themeList = new JList();
		themeScrollPane.setViewportView(themeList);
		themeList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Tema l", "Tema m", "Tema n", "Tema o", "Tema p", "Tema q", "Tema r", "Tema s", "Tema t"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JList kahootList = new JList();
		kahootList.setModel(new AbstractListModel() {
			String[] values = new String[] {"nom Kahoot 1", "nom Kahoot 2", "nom Kahoot 3", "nom Kahoot 4", "nom Kahoot 5", "nom Kahoot 6", "nom Kahoot 7", "nom Kahoot 8", "nom Kahoot 9"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		kahootScrollPane.setViewportView(kahootList);
		contentPane.setLayout(gl_contentPane);
		
		btnSelectTheme.addActionListener((ActionListener) new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Needs funcionality
				
			}
		});
	}
}