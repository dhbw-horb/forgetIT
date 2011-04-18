/*
 * Copyright 2011 DHBW Stuttgart Campus Horb
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either 
 * express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
