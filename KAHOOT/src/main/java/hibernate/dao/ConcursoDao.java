package hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.model.Concursante;
import hibernate.model.Concurso;
import hibernate.util.HibernateUtil;

public class ConcursoDao {
	public ConcursoDao() {}
	
	public void saveConcurso(Concurso concurso) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.save(concurso);
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
	}
	public void updateConcurso(Concurso concurso) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.saveOrUpdate(concurso);
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
	}
	
	public Concurso getConcursoById(int id) {
		Transaction transaction = null;
		Concurso concurso = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			concurso = session.get(Concurso.class, id);
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
		
		return concurso;
	}
	
	@SuppressWarnings("unchecked")
	public List<Concurso> getAllConcursos() {
		Transaction transaction = null;
		List<Concurso> concursos = new ArrayList<Concurso>();
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			concursos = session.createQuery("from concurso").list();
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
		
		return concursos;
	}
	
	public void deleteConcurso(Concurso concurso) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.delete(concurso);
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
	}

}
