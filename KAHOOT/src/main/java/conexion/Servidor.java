package main.java.conexion;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import main.java.conexion.Interfaz;
import lipermi.exception.LipeRMIException;
import lipermi.handler.CallHandler;
import lipermi.net.IServerListener;
import lipermi.net.Server;

public class Servidor implements Interfaz {
	private ArrayList<String> concursantes = new ArrayList<String>();

    public Servidor() {
        try {
            CallHandler callHandler = new CallHandler();
            callHandler.registerGlobal(Interfaz.class, this);
            Server server = new Server();
            server.bind(7779, callHandler);
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
	}

}


