package main.java.hibernate.app;

import java.util.List;

import main.java.hibernate.dao.KahootDao;
import main.java.hibernate.dao.PreguntaDao;
import main.java.hibernate.dao.RespuestaDao;
import main.java.hibernate.dao.UsuarioDao;
import main.java.hibernate.model.Kahoot;
import main.java.hibernate.model.Pregunta;
import main.java.hibernate.model.Respuesta;
import main.java.hibernate.model.Usuario;

public class App {
	public static void main(String[] args) {
		KahootDao kd = new KahootDao();
		UsuarioDao ud = new UsuarioDao();
		List<Kahoot> kahoots = kd.getAllKahoots();
		System.out.println(kahoots);
		List<Usuario> users = ud.getAllUsuarios();
		System.out.println(users);
		
		List<String> categorias = kd.getAllCategorias();
		for (String categoria : categorias) {
			System.out.println(categoria);
		}
	}

}
