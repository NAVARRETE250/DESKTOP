package main.java.app;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.java.conexion.Servidor;
import main.java.hibernate.model.Concursante;
import main.java.hibernate.model.Pregunta;
import main.java.readXML.KahootConfiguration;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class SalaDeEspera extends JFrame {

	private JPanel contentPane;
	private JLabel lblTituloDelKahoot_1;
	private JList playerList;
	private JScrollPane playerScrollPane;
	private ArrayList<Concursante> players = new ArrayList<Concursante>();
	private Timer playerTimer;

	/**
	 * Create the frame.
	 * @throws SocketException 
	 * @throws UnknownHostException 
	 */
	public SalaDeEspera(final KahootConfiguration config) throws SocketException, UnknownHostException {
		new Servidor();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("LOBBY");
		
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
		
		JButton btnComenzar = new JButton("comenzar");
		btnComenzar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final Timer timer = new Timer();

		        timer.scheduleAtFixedRate(new TimerTask() {
		            int i =  Integer.valueOf(config.getMaxQuestions());

		            public void run() {

		                lblTempo.setText(i+"");
		                i--;
		                if (i < 0) {
		                    timer.cancel();
		                    playerTimer.cancel();
		                    lblTempo.setText("Time Over");
		                    new KahootContest(config);
		                }
		            }
		        }, 0, 1000);
			}
			
		});
				
		playerScrollPane = new JScrollPane();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEsperandoJugadores)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTituloDelKahoot_1)
							.addGap(117)
							.addComponent(lblIp))
						.addComponent(playerScrollPane, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
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
					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnComenzar)
						.addComponent(playerScrollPane, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
					.addGap(28))
		);
		
		playerList = new JList();
		playerScrollPane.setViewportView(playerList);
		contentPane.setLayout(gl_contentPane);	

		final Timer playerTimer = new Timer();

        playerTimer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
               updatePlayerList();
            }
        }, 1000, 50);
		
	}
	private void updatePlayerList() {
		//Reset Player list to display questions in panel
		String[] playerNames = new String[players.size()];
		for (int i = 0; i < players.size(); i++ ){
			playerNames[i] = players.get(i).getNickname();
			} 
		playerList = new JList(playerNames);

		//Update panel viewport
		playerScrollPane.setViewportView(playerList);
		}
}