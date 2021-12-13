package hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.model.Respuesta;
import hibernate.util.HibernateUtil;

public class RespuestaDao {
	public RespuestaDao() {}
		
		public void saveRespuesta(Respuesta respuesta) {
			Transaction transaction = null;
			
			try(Session session = HibernateUtil.getSessionFactory().openSession()){
				transaction = session.beginTransaction();
				
				session.save(respuesta);
				
				transaction.commit();
			}catch (Exception e) {
				if(transaction != null) {
					transaction.rollback();	
				}
			}
		}
		public void updateRespuesta(Respuesta respuesta) {
			Transaction transaction = null;
			
			try(Session session = HibernateUtil.getSessionFactory().openSession()){
				transaction = session.beginTransaction();
				
				session.saveOrUpdate(respuesta);
				
				transaction.commit();
			}catch (Exception e) {
				if(transaction != null) {
					transaction.rollback();	
				}
			}
		}
		
		public Respuesta getRespuestaById(int id) {
			Transaction transaction = null;
			Respuesta respuesta = null;
			
			try(Session session = HibernateUtil.getSessionFactory().openSession()){
				transaction = session.beginTransaction();
				
				respuesta = session.get(Respuesta.class, id);
				
				transaction.commit();
			}catch (Exception e) {
				if(transaction != null) {
					transaction.rollback();	
				}
			}
			
			return respuesta;
		}
		
		@SuppressWarnings("unchecked")
		public List<Respuesta> getAllRespuestas() {
			Transaction transaction = null;
			List<Respuesta> respuestas = new ArrayList<Respuesta>();
			
			try(Session session = HibernateUtil.getSessionFactory().openSession()){
				transaction = session.beginTransaction();
				
				respuestas = session.createQuery("from respuesta").list();
				
				transaction.commit();
			}catch (Exception e) {
				if(transaction != null) {
					transaction.rollback();	
				}
			}
			
			return respuestas;
		}
		
		public void deleteRespuesta(Respuesta respuesta) {
			Transaction transaction = null;
			
			try(Session session = HibernateUtil.getSessionFactory().openSession()){
				transaction = session.beginTransaction();
				
				session.delete(respuesta);
				
				transaction.commit();
			}catch (Exception e) {
				if(transaction != null) {
					transaction.rollback();	
				}
			}
		}
}
