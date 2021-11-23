package main.java.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import main.java.hibernate.model.Pregunta;
import main.java.hibernate.util.HibernateUtil;

public class PreguntaDao {
	public PreguntaDao() {}
	
	public void savePregunta(Pregunta pregunta) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.save(pregunta);
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
	}
	public void updatePregunta(Pregunta pregunta) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.saveOrUpdate(pregunta);
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
	}
	
	public Pregunta getPreguntaById(int id) {
		Transaction transaction = null;
		Pregunta pregunta = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			pregunta = session.get(Pregunta.class, id);
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
		
		return pregunta;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pregunta> getAllPreguntas() {
		Transaction transaction = null;
		List<Pregunta> preguntas = new ArrayList<Pregunta>();
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			preguntas = session.createQuery("from pregunta").list();
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
		
		return preguntas;
	}
	
	public void deletePregunta(Pregunta pregunta) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.delete(pregunta);
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
	}
}
