package main.java.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.java.hibernate.model.Usuario;
import main.java.hibernate.util.HibernateUtil;

public class UsuarioDao {
	public UsuarioDao() {}
	
	public void saveUsuario(Usuario usuario) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.save(usuario);
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
	}
	public void updateUsuario(Usuario usuario) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.saveOrUpdate(usuario);
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
	}
	
	public Usuario getUsuarioById(int id) {
		Transaction transaction = null;
		Usuario usuario = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			usuario = session.get(Usuario.class, id);
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
		
		return usuario;
	}
	
	public Usuario getUsuarioByName(String nombre) {
		Transaction transaction = null;
		Usuario usuario = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			usuario = (Usuario) session.createQuery("from usuario u where u.nombre='"+nombre+"'").uniqueResult();
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
		
		return usuario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> getAllUsuarios() {
		Transaction transaction = null;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			usuarios = session.createQuery("from usuario").list();
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
		
		return usuarios;
	}
	
	public void deleteUsuario(Usuario usuario) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.delete(usuario);
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
	}

}
