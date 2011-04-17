package forgetit.db;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import forgetit.common.Tag;

/**
 * 
 * @author David Henn
 * @see IDBTags
 * 
 */
public class DBTags implements IDBTags {

	final static Logger logger = LoggerFactory.getLogger(DBTags.class);

	@Override
	public List<Tag> getTags() {

		Transaction tx = null;
		Session session = SessionFactoryUtil.getInstance().getCurrentSession();
		try {
			tx = session.beginTransaction();
			List tags = session.createQuery("select t from Tag as t").list();
			for (Iterator iter = tags.iterator(); iter.hasNext();) {
				Tag element = (Tag) iter.next();
				logger.debug("{}", element);
				logger.info("{}", element.getId());
				logger.info("{}", element.getName());
				logger.info("{}", element.getDescription());
			}
			tx.commit();
			return tags;
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

}
