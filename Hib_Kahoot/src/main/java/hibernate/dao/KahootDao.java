package hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.model.Kahoot;
import hibernate.util.HibernateUtil;

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

}
