package conexion;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;

import app.kahootManagerScreen;
import conexion.Interfaz;
import hibernate.dao.KahootDao;
import hibernate.dao.PreguntaDao;
import hibernate.model.Concursante;
import hibernate.model.Kahoot;
import hibernate.model.Pregunta;
import hibernate.model.Respuesta;
import lipermi.exception.LipeRMIException;
import lipermi.handler.CallHandler;
import lipermi.net.IServerListener;
import lipermi.net.Server;

public class Servidor implements Interfaz {
	private Kahoot kahoot = kahootManagerScreen.getKahoot();
	private Server server;
	private ArrayList<String> nombres_concursantes = new ArrayList<String>();
	private ArrayList<Concursante> concursantes = new ArrayList<Concursante>();
	private JList listaJugadores = new JList();
	DefaultListModel modelo = new DefaultListModel();
	private static boolean kahootStarted = false;
	ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
	private boolean tiempoAcabado = false;
	private int ronda = 0;
	private int tiempoRestante;
	private boolean ultimaPregunta;
	
	public static void main(String[] args) {
		new Servidor();
	}

    public Servidor() {
        try {
            CallHandler callHandler = new CallHandler();
            callHandler.registerGlobal(Interfaz.class, this);
            server = new Server();
            server.bind(8030, callHandler);
            server.addServerListener(new IServerListener() {
                
                @Override
                public void clientDisconnected(Socket socket) {
                    System.out.println("Client Disconnected: " + socket.getInetAddress());
                }
                
                @Override
                public void clientConnected(Socket socket) {
                    System.out.println("Client Connected: " + socket.getInetAddress());
                }
            });
            System.out.println("Server Listening");
        } catch (LipeRMIException | IOException e) {
            e.printStackTrace();
        }
    }
    public String getResponse(String data) {
        System.out.println("getResponse called");
        return "Your data: " + data;
    }

	@Override
	public void sendUsername(String username) {
		nombres_concursantes.add(username);
		concursantes.add(new Concursante(username,0));
		modelo.addElement(username);
		listaJugadores.setModel(modelo);
	}

	@Override
	public ArrayList<String> getAllUsernames() {
		return nombres_concursantes;
	}

	public ArrayList<String> getConcursantes() {
		return nombres_concursantes;
	}

	public void setConcursantes(ArrayList<String> concursantes) {
		this.nombres_concursantes = concursantes;
	}

	public JList getListaJugadores() {
		return listaJugadores;
	}

	public void setListaJugadores(JList listaJugadores) {
		this.listaJugadores = listaJugadores;
	}
	

	public static void setKahootStarted(boolean kahootStarted) {
		Servidor.kahootStarted = kahootStarted;
	}

	@Override
	public boolean kahootIsStarted() {
		// TODO Auto-generated method stub
		return kahootStarted;
	}
	
	
	public void closeServer() {
		server.close();
	}

	@Override
	public ArrayList<String> getRespuestas(int ronda) {
		KahootDao kd = new KahootDao();
		PreguntaDao pd = new PreguntaDao();
		ArrayList<Pregunta> preguntas = (ArrayList<Pregunta>) kd.getPreguntas(kahoot);
		this.respuestas = (ArrayList<Respuesta>) pd.getRespuestas(preguntas.get(ronda));
		ArrayList<String> enunciadoRespuestas = new ArrayList<String>();
		for (Respuesta respuesta : respuestas) {
			enunciadoRespuestas.add(respuesta.getSolucion());
		}
		return enunciadoRespuestas;
	}

	public Kahoot getKahoot() {
		return kahoot;
	}

	public void setKahoot(Kahoot kahoot) {
		this.kahoot = kahoot;
	}
	
	

	public boolean isTiempoAcabado() {
		return tiempoAcabado;
	}

	public void setTiempoAcabado(boolean tiempoAcabado) {
		this.tiempoAcabado = tiempoAcabado;
	}

	@Override
	public ArrayList<Boolean> getSoluciones() {
		ArrayList<Boolean> soluciones = new ArrayList<Boolean>();
		for (Respuesta respuesta : respuestas) {
			soluciones.add(respuesta.isCorrecto());
		}
		return soluciones;
	}

	@Override
	public boolean tiempoAcabado() {
		// TODO Auto-generated method stub
		return tiempoAcabado;
	}

	@Override
	public int getRonda() {
		// TODO Auto-generated method stub
		return ronda;
	}
	public void setRonda(int ronda) {
		this.ronda = ronda;
	}

	@Override
	public int getTiempoRestante() {
		// TODO Auto-generated method stub
		return tiempoRestante;
	}
	
	public void setTiempoRestante(int segundos) {
		this.tiempoRestante = segundos;
	}
	
	public ArrayList<Concursante> getListaConcursantes(){
		return this.concursantes;
	}

	public void sendPuntuacion(String username, int puntuacion) {
		for (Concursante concursante : concursantes) {
			if(concursante.getNickname().equals(username)) {
				concursante.setPuntuacion_total(puntuacion);
			}
		}
	}

	
	public void setUltimaPregunta(boolean p) {
		this.ultimaPregunta = p;
	}
	
	
	@Override
	public boolean ultimaPregunta() {
		// TODO Auto-generated method stub
		return ultimaPregunta;
	}

	
}


