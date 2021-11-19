package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hibernate.dao.KahootDao;
import hibernate.dao.PreguntaDao;
import hibernate.model.Kahoot;
import hibernate.model.Pregunta;
import hibernate.model.Respuesta;
import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class PantallaConcurso extends JFrame {
	
	private JPanel contentPane;
	private KahootDao kd = new KahootDao();
	private PreguntaDao pd = new PreguntaDao();
	private Kahoot kahoot = kahootManagerScreen.getKahoot();
	private List<Pregunta> preguntas = kd.getPreguntas(kahoot);
	private int timeout = Pantalla_Login.getTimeout();
	private boolean ultimaPregunta = false;
	private JButton btnSiguientePregunta;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaConcurso frame = new PantallaConcurso(0);
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
	public PantallaConcurso(final int numPregunta) {
		if(numPregunta == preguntas.size()-1) {
			ultimaPregunta = true;
		}
		final int ronda = numPregunta + 1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("KAHOOT");
		contentPane.setLayout(new BorderLayout(0, 0));
		
		Pregunta pregunta = preguntas.get(numPregunta);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2,2));
		List<Respuesta> respuestas = pd.getRespuestas(pregunta);
		final List<LabelRespuesta> labelrespuestas = new ArrayList<LabelRespuesta>();
		for (int i = 0; i < respuestas.size(); i++) {
			Respuesta respuesta = respuestas.get(i);
			LabelRespuesta lr = new LabelRespuesta(respuesta);
			if(i == 0) {
				lr.setBackground(Color.RED);
			}
			if(i == 1) {
				lr.setBackground(Color.BLUE);
			}
			if(i == 2) {
				lr.setBackground(Color.YELLOW);
			}
			if(i == 3) {
				lr.setBackground(Color.GREEN);
			}
			lr.setOpaque(true);
			panel.add(lr);
			labelrespuestas.add(lr);
		}
		JLabel lblPregunta = new JLabel("PREGUNTA");
		lblPregunta.setText(pregunta.getEnunciado());
		lblPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblPregunta, BorderLayout.NORTH);
		
		JPanel panelSouth = new JPanel();
		panelSouth.setLayout(new FlowLayout());
		if(ultimaPregunta) {
			btnSiguientePregunta = new JButton("Finalizar");
		}else {
			btnSiguientePregunta = new JButton("Siguiente pregunta");
		}
		btnSiguientePregunta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(ultimaPregunta) {
					kahootManagerScreen kms = new kahootManagerScreen();
					kms.setVisible(true);
				}else {
					PantallaConcurso pc = new PantallaConcurso(ronda);
					pc.setVisible(true);
				}
			}
			
		});
		btnSiguientePregunta.setEnabled(false);
		panelSouth.add(btnSiguientePregunta);
		final JLabel tiempo = new JLabel("");
		final Timer timer = new Timer();
        panelSouth.add(tiempo);
		contentPane.add(panelSouth, BorderLayout.SOUTH);

        timer.scheduleAtFixedRate(new TimerTask() {
            int i = timeout;

            public void run() {

                tiempo.setText(i+"");
                i--;
                if (i < 0) {
                    timer.cancel();
                    for(LabelRespuesta lr : labelrespuestas) {
                    	if(!lr.getRespuesta().isCorrecto()) {
                    		lr.setBackground(Color.GRAY);
                    	}
                    }
                    btnSiguientePregunta.setEnabled(true);
                }
            }
        }, 0, 1000);
	}

}

class LabelRespuesta extends JLabel{
	private Respuesta respuesta;
	LabelRespuesta(Respuesta respuesta){
		this.respuesta = respuesta;
		this.setText(respuesta.getSolucion());
	}
	public Respuesta getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}
	
}
