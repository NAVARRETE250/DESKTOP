package main.java.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import main.java.hibernate.model.RespuestaConcurso;
import main.java.hibernate.util.HibernateUtil;


public class RespuestaConcursoDao {

	public RespuestaConcursoDao() {}
	
	public void saveRespuestaConcurso(RespuestaConcurso respuestaConcurso) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.save(respuestaConcurso);
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
	}
	
	public RespuestaConcurso getRespuestaConcursoById(int id) {
		Transaction transaction = null;
		RespuestaConcurso respuestaConcurso = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			respuestaConcurso = session.get(RespuestaConcurso.class, id);
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
		
		return respuestaConcurso;
	}
	
	@SuppressWarnings("unchecked")
	public List<RespuestaConcurso> getAllRespuestasConcurso() {
		Transaction transaction = null;
		List<RespuestaConcurso> concursantes = new ArrayList<RespuestaConcurso>();
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			concursantes = session.createQuery("from respuesta_concurso").list();
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
		
		return concursantes;
	}
	
	public boolean respuestaConcursoExists(String id) {
		Transaction transaction = null;
		RespuestaConcurso respuestaConcurso = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			respuestaConcurso = (RespuestaConcurso) session.createQuery("from respuesta_concurso c where c.id_respuesta_concurso='"+id+"'").uniqueResult();
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
		
		if(respuestaConcurso == null) {
			return false;
		}else {
			return true;
		}
	}

}
