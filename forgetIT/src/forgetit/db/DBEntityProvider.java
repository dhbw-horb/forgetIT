package forgetit.db;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import forgetit.common.Date;
import forgetit.common.Entity;
import forgetit.common.Tag;

/**
 * 
 * @author David Henn
 * @see IDBEntityProvider
 * 
 */
public class DBEntityProvider implements IDBEntityProvider {
	
	final static Logger logger = LoggerFactory.getLogger(DBEntityHandler.class);

	@Override
	public List<Entity> getEntities() {

		Transaction tx = null;
		Session session = SessionFactoryUtil.getInstance().getCurrentSession();
		try {
			tx = session.beginTransaction();
			List entities = session.createQuery("select e from Entity as e").list();
			for (Iterator iter = entities.iterator(); iter.hasNext();) {
				Entity element = (Entity) iter.next();
				logger.debug("{}", element);
				logger.info("{}", element.getId());
				logger.info("{}", element.getTitle());
				logger.info("{}", element.getDescription());
			}
			tx.commit();
			return entities;
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive()) {
				try {
					tx.rollback();
				} catch (HibernateException e1) {
					logger.debug("Error rolling back transaction");
				}
				throw e;
			}
		}
		return null;
	

	}

	public List<Entity> getEntities(Date startDate, Date endDate) {

		// TODO Auto-generated method stub
		return null;
	}

	public List<Entity> getEntities(Date startDate, Date endDate, List<Tag> tags) {

		// TODO Auto-generated method stub
		return null;
	}

	public List<Entity> getEntities(List<Tag> tags) {

		// TODO Auto-generated method stub
		return null;
	}

	

}
