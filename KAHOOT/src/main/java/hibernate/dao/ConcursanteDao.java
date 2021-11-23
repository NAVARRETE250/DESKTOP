package main.java.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import main.java.hibernate.model.Concursante;
import main.java.hibernate.model.Usuario;
import main.java.hibernate.util.HibernateUtil;

public class ConcursanteDao {
	
	public ConcursanteDao() {}
	
	public void saveConcursante(Concursante concursante) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.save(concursante);
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
	}
	public void updateConcursante(Concursante concursante) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.saveOrUpdate(concursante);
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
	}
	
	public Concursante getConcursanteById(int id) {
		Transaction transaction = null;
		Concursante concursante = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			concursante = session.get(Concursante.class, id);
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
		
		return concursante;
	}
	
	@SuppressWarnings("unchecked")
	public List<Concursante> getAllConcursantes() {
		Transaction transaction = null;
		List<Concursante> concursantes = new ArrayList<Concursante>();
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			concursantes = session.createQuery("from concursante").list();
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
		
		return concursantes;
	}
	
	public void deleteConcursante(Concursante concursante) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.delete(concursante);
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
	}
	
	public boolean concursanteExists(String nombre) {
		Transaction transaction = null;
		Concursante concursante = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			concursante = (Concursante) session.createQuery("from concursante c where c.nickname='"+nombre+"'").uniqueResult();
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
		
		if(concursante == null) {
			return false;
		}else {
			return true;
		}
	}

}
