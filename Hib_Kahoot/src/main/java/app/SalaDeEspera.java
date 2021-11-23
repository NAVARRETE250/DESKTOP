package app;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexion.Servidor;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;

public class SalaDeEspera extends JFrame {

	private JPanel contentPane;
	static Servidor server;
	private JLabel lblTituloDelKahoot_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalaDeEspera frame = new SalaDeEspera();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SocketException 
	 * @throws UnknownHostException 
	 */
	public SalaDeEspera() throws SocketException, UnknownHostException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("SALA DE ESPERA");
		
		server = new Servidor();
		
		JLabel lblTituloDelKahoot = null;
		try {
			lblTituloDelKahoot_1 = new JLabel(kahootManagerScreen.getKahoot().getTitulo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblEsperandoJugadores = new JLabel("esperando jugadores");
		
		String ip;
		try(final DatagramSocket socket = new DatagramSocket()){
			  socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
			  ip = socket.getLocalAddress().getHostAddress();
			}
		
		JLabel lblIp = new JLabel(ip);
		
		final JLabel lblTempo = new JLabel("");
		
		JButton btnComenzar = new JButton("Comenzar");
		btnComenzar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				final Timer timer = new Timer();

		        timer.scheduleAtFixedRate(new TimerTask() {
		            int i = 10;

		            public void run() {

		                lblTempo.setText(i+"");
		                i--;
		                if (i < 0) {
		                    timer.cancel();
		                    server.setKahootStarted(true);
		                    PantallaConcurso pc = new PantallaConcurso(0);
		    				pc.setVisible(true);
		    				dispose();
		                }
		            }
		        }, 0, 1000);
			}
			
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblTituloDelKahoot_1)
									.addGap(117)
									.addComponent(lblIp))
								.addComponent(lblEsperandoJugadores)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTempo)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnComenzar)
							.addGap(44))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTituloDelKahoot_1)
								.addComponent(lblIp))
							.addGap(18)
							.addComponent(lblEsperandoJugadores))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(45)
							.addComponent(lblTempo)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnComenzar)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JList list = server.getListaJugadores();
		scrollPane.setViewportView(list);
		contentPane.setLayout(gl_contentPane);



}
}