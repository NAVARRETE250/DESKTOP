package main.java.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;

import main.java.hibernate.model.Kahoot;
import main.java.hibernate.model.Pregunta;
import main.java.hibernate.util.HibernateUtil;

public class KahootDao {
	public KahootDao() {}
		
		public void saveKahoot(Kahoot kahoot) {
			Transaction transaction = null;
			
			try(Session session = HibernateUtil.getSessionFactory().openSession()){
				transaction = session.beginTransaction();
				
				session.save(kahoot);
				
				transaction.commit();
			}catch (Exception e) {
				if(transaction != null) {
					transaction.rollback();	
				}
			}
		}
		public void updateKahoot(Kahoot kahoot) {
			Transaction transaction = null;
			
			try(Session session = HibernateUtil.getSessionFactory().openSession()){
				transaction = session.beginTransaction();
				
				session.saveOrUpdate(kahoot);
				
				transaction.commit();
			}catch (Exception e) {
				if(transaction != null) {
					transaction.rollback();	
				}
			}
		}
		
		public Kahoot getKahootById(int id) {
			Transaction transaction = null;
			Kahoot kahoot = null;
			
			try(Session session = HibernateUtil.getSessionFactory().openSession()){
				transaction = session.beginTransaction();
				
				kahoot = session.get(Kahoot.class, id);
				
				transaction.commit();
			}catch (Exception e) {
				if(transaction != null) {
					transaction.rollback();	
				}
			}
			
			return kahoot;
		}
		
		@SuppressWarnings("unchecked")
		public List<Kahoot> getAllKahoots() {
			Transaction transaction = null;
			List<Kahoot> kahoots = new ArrayList<Kahoot>();
			
			try(Session session = HibernateUtil.getSessionFactory().openSession()){
				transaction = session.beginTransaction();
				
				kahoots = session.createQuery("from kahoot").list();

				transaction.commit();
			}catch (Exception e) {
				if(transaction != null) {
					transaction.rollback();	
				}
			}
			
			return kahoots;
		}
		
		public void deleteKahoot(Kahoot kahoot) {
			Transaction transaction = null;
			
			try(Session session = HibernateUtil.getSessionFactory().openSession()){
				transaction = session.beginTransaction();
				
				session.delete(kahoot);
				
				transaction.commit();
			}catch (Exception e) {
				if(transaction != null) {
					transaction.rollback();	
				}
			}
		}
		public List<Kahoot> getKahootsByCategoria(String categoria){
			Transaction transaction = null;
			List<Kahoot> kahoots = new ArrayList<Kahoot>();
			
			try(Session session = HibernateUtil.getSessionFactory().openSession()){
				transaction = session.beginTransaction();
				
				kahoots = session.createQuery("from kahoot k where k.categoria='"+categoria+"'").list();

				transaction.commit();
			}catch (Exception e) {
				if(transaction != null) {
					transaction.rollback();	
				}
			}
			
			return kahoots;
		}
		
		public List<String> getAllCategorias(){
			Transaction transaction = null;
			List<String> categorias = new ArrayList<String>();
			
			try(Session session = HibernateUtil.getSessionFactory().openSession()){
				transaction = session.beginTransaction();
				
				categorias = session.createQuery("select k.categoria from kahoot k").list();

				transaction.commit();
			}catch (Exception e) {
				if(transaction != null) {
					transaction.rollback();	
				}
			}
			
			return categorias;
		}
		public List<Pregunta> getPreguntas(Kahoot kahoot){
			Transaction transaction = null;
			List<Pregunta> preguntas = new ArrayList<Pregunta>();
			
			try(Session session = HibernateUtil.getSessionFactory().openSession()){
				transaction = session.beginTransaction();
				
				preguntas = session.createQuery("from pregunta p where p.id_kahoot = "+kahoot.getId_kahoot()).list();

				transaction.commit();
			}catch (Exception e) {
				if(transaction != null) {
					transaction.rollback();	
				}
			}
			
			return preguntas;
		}
		

}
