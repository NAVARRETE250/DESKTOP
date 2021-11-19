package app;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import errorHandling.CustomException;
import errorHandling.ErrorHandler;
import hibernate.dao.UsuarioDao;
import hibernate.model.Usuario;
import readXML.DesktopTemplate;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Pantalla_Login extends JFrame {

	private JPanel contentPane;
	private JTextField usuarioField;
	private JPasswordField contraField;
	static Usuario user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		DesktopTemplate deskTemp = new DesktopTemplate();
		deskTemp.readConfigFile();
		System.out.println(deskTemp.getLanguage());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla_Login frame = new Pantalla_Login();
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
	public Pantalla_Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Pantalla LOGIN");
		
		JLabel lblKadamm = new JLabel("KADAMM!");
		lblKadamm.setForeground(new Color(128, 0, 0));
		lblKadamm.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 80));
		lblKadamm.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("DialogInput", Font.BOLD, 24));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("DialogInput", Font.BOLD, 24));
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		
		usuarioField = new JTextField();
		usuarioField.setColumns(10);
		
		contraField = new JPasswordField();
		contraField.setColumns(10);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/kahoot_logo.png")).getImage();
		label.setIcon(new ImageIcon(img));
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBackground(new Color(102, 51, 153));
		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				UsuarioDao usDao = new UsuarioDao();
				try {
				user = usDao.getUsuarioByName(usuarioField.getText());
				if (user == null) {
					throw new CustomException("USUARIO no encontrado");
				}else {
					if (!user.getContraseña().equals(contraField.getText())) {
						throw new CustomException("CONTRASEÑA incorrecta");
					}else {
						//Abrir ventana gestión kahoots
						kahootManagerScreen kms = new kahootManagerScreen();
						kms.setVisible(true);
						dispose();
					}
				}
				
			}catch(CustomException ce) {
				JOptionPane.showMessageDialog(null, ce.getMessageToShow(), "Aviso",
						JOptionPane.ERROR_MESSAGE);
			}
			}
			
		});
		
		JButton btnRecordarContrasea = new JButton("Recordar Contraseña");
		btnRecordarContrasea.setBackground(new Color(153, 51, 204));
		btnRecordarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PantallaRecordarContra prc = new PantallaRecordarContra();
				prc.setVisible(true);
			}
			
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(233, Short.MAX_VALUE)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
					.addGap(203))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(120, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblUsuario)
									.addGap(54))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblContrasea)
									.addGap(37)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(usuarioField, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE)
								.addComponent(contraField, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(102)
							.addComponent(lblKadamm, GroupLayout.PREFERRED_SIZE, 589, Short.MAX_VALUE)))
					.addGap(99))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(325, Short.MAX_VALUE)
					.addComponent(btnRecordarContrasea)
					.addGap(307))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(274)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(269, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(lblKadamm, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(usuarioField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsuario))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblContrasea)
						.addComponent(contraField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRecordarContrasea)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGap(12)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 213, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}