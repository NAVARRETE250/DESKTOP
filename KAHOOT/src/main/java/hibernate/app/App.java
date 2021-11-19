package hibernate.app;

import java.util.List;

import hibernate.dao.KahootDao;
import hibernate.dao.PreguntaDao;
import hibernate.dao.RespuestaDao;
import hibernate.dao.UsuarioDao;
import hibernate.model.Kahoot;
import hibernate.model.Pregunta;
import hibernate.model.Respuesta;
import hibernate.model.Usuario;

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
