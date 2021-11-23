import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PantallaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField usuarioField;
	private JTextField contraField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaLogin frame = new PantallaLogin();
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
	public PantallaLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 800);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
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
		
		contraField = new JTextField();
		contraField.setColumns(10);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/kahoot_logo.png")).getImage();
		label.setIcon(new ImageIcon(img));
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBackground(new Color(102, 51, 153));
		
		JButton btnRecordarContrasenia = new JButton("Recordar contrasenia");
		btnRecordarContrasenia.setBackground(new Color(153, 51, 204));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(138)
							.addComponent(lblUsuario))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(119)
							.addComponent(lblContrasea)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(usuarioField, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
								.addComponent(contraField, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(327, Short.MAX_VALUE)
					.addComponent(btnRecordarContrasenia)
					.addGap(307))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(233, Short.MAX_VALUE)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
					.addGap(203))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(102)
					.addComponent(lblKadamm, GroupLayout.PREFERRED_SIZE, 589, Short.MAX_VALUE)
					.addGap(99))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(lblKadamm, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsuario)
						.addComponent(usuarioField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(66)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblContrasea)
						.addComponent(contraField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnRecordarContrasenia)
					.addGap(9)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
					.addGap(77))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
