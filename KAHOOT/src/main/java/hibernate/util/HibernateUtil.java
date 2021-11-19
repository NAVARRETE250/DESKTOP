package hibernate.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import hibernate.model.Usuario;
import hibernate.model.Kahoot;
import hibernate.model.Concursante;
import hibernate.model.Concurso;
import hibernate.model.Pregunta;
import hibernate.model.Respuesta;


public class HibernateUtil {

	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				// Nombre BBDD
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/Kahoot");
				// Nombre user
				settings.put(Environment.USER, "root");
				// Nombre contraseña
				settings.put(Environment.PASS, "Root123_");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);
				
				//configuration.addAnnotatedClass(Table1.class);
				configuration.addAnnotatedClass(Usuario.class);
				configuration.addAnnotatedClass(Kahoot.class);
				configuration.addAnnotatedClass(Concursante.class);
				configuration.addAnnotatedClass(Concurso.class);
				configuration.addAnnotatedClass(Pregunta.class);
				configuration.addAnnotatedClass(Respuesta.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
