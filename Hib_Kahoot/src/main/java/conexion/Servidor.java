package conexion;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;

import conexion.Interfaz;
import hibernate.dao.KahootDao;
import hibernate.dao.PreguntaDao;
import hibernate.model.Kahoot;
import hibernate.model.Pregunta;
import hibernate.model.Respuesta;
import lipermi.exception.LipeRMIException;
import lipermi.handler.CallHandler;
import lipermi.net.IServerListener;
import lipermi.net.Server;

public class Servidor implements Interfaz {
	private Kahoot kahoot;
	private Server server;
	private ArrayList<String> concursantes = new ArrayList<String>();
	private JList listaJugadores = new JList();
	DefaultListModel modelo = new DefaultListModel();
	private static boolean kahootStarted = false;
	
	
	public static void main(String[] args) {
		new Servidor();
	}

    public Servidor() {
        try {
            CallHandler callHandler = new CallHandler();
            callHandler.registerGlobal(Interfaz.class, this);
            server = new Server();
            server.bind(8010, callHandler);
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
		concursantes.add(username);
		modelo.addElement(username);
		listaJugadores.setModel(modelo);
	}

	@Override
	public ArrayList<String> getAllUsernames() {
		return concursantes;
	}

	public ArrayList<String> getConcursantes() {
		return concursantes;
	}

	public void setConcursantes(ArrayList<String> concursantes) {
		this.concursantes = concursantes;
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
		List<Respuesta> respuestas = pd.getRespuestas(preguntas.get(ronda));
		ArrayList<String> enunciadoRespuestas = new ArrayList<String>();
		
		return null;
	}

	public Kahoot getKahoot() {
		return kahoot;
	}

	public void setKahoot(Kahoot kahoot) {
		this.kahoot = kahoot;
	}
	
	

}


