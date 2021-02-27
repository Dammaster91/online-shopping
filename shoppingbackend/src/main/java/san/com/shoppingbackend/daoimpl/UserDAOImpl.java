package san.com.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import san.com.shoppingbackend.dao.UserDAO;
import san.com.shoppingbackend.dto.Address;
import san.com.shoppingbackend.dto.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {
		Session session = null;
		Integer id = 0;
		try {
			session = sessionFactory.openSession();
			id = (Integer) session.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		if (id != 0) {
			return true;
		} else {
			return false;

		}

	}

	@Override
	public boolean addAddress(Address address) {

		Session session = null;
		Integer id = 0;
		try {
			session = sessionFactory.openSession();
			id = (Integer) session.save(address);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		if (id != 0) {
			return true;
		} else {
			return false;

		}

	}

	@Override
	public User getByEmail(String email) {
		Session session = sessionFactory.openSession();
		System.out.println(session);
		try {
			Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("email", email));

			User result = (User) criteria.uniqueResult();
			if (result != null) {
				User genre = (User) result;
			}

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Address getBillingAddress(User user) {

		Session session = sessionFactory.openSession();
		System.out.println(session);

		Criteria criteria = session.createCriteria(Address.class).add(Restrictions.eq("user", user))
				.add(Restrictions.eq("billing", true));

		Address result = (Address) criteria.uniqueResult();
		if (result != null) {
			Address genre = (Address) result;
		}

		return result;

	}

	@Override
	public List<Address> listShippingAddress(User user) {

		Session session = sessionFactory.openSession();
		System.out.println(session);

		Criteria criteria = session.createCriteria(Address.class).add(Restrictions.eq("user", user))
				.add(Restrictions.eq("shipping", true));

		List<Address> result = criteria.list();

		return result;

	}

	/*
	 * 
	 * String selectQuery = "From User User where email=:email"; try { return
	 * sessionFactory.getCurrentSession() .createQuery(selectQuery,User.class).
	 * setParameter("email", email) .getSingleResult(); } catch (Exception ex) {
	 * 
	 * }
	 * 
	 * return null;
	 */
}
