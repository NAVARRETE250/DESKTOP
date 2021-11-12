package hibernate.app;

import hibernate.dao.UsuarioDao;
import hibernate.model.Usuario;

public class App {
	public static void main(String[] args) {
		UsuarioDao usDao = new UsuarioDao();
		
		Usuario usuario = new Usuario("Pau2","pau1232");
		Usuario usuario2 = new Usuario("Pau3","aaaa");
		usDao.saveUsuario(usuario);
		usDao.saveUsuario(usuario2);
		Usuario us = usDao.getUsuarioByName("Pau3");
		System.out.println(us.getContraseña());
		
	}

}
