package san.com.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import san.com.shoppingbackend.dao.ProductDAO;
import san.com.shoppingbackend.dto.Product;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> list() {
		System.out.println("control in getStudentDetailsList daoimpl");

		Session session = sessionFactory.openSession();
		System.out.println(session);

		ProjectionList pList = Projections.projectionList();
		pList.add(Projections.property("id"), "id");

		Criteria criteria = session.createCriteria(Product.class).setProjection(pList);

		List<Product> listStdentRegDto = criteria.setResultTransformer(new AliasToBeanResultTransformer(Product.class))
				.list();

		return listStdentRegDto;
	}

	@Override
	public Product get(int id) {
		Session session = sessionFactory.openSession();
		System.out.println(session);

		Criteria criteria = session.createCriteria(Product.class).add(Restrictions.eq("id", id));

		Product result = (Product) criteria.uniqueResult();
		if (result != null) {
			Product genre = (Product) result;
		}

		return result;

	}

	@Override

	public boolean add(Product product) {
		Session session = null;
		Transaction transaction = null;
		Integer id = 0;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			transaction.begin();

			id = (Integer) session.save(product);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
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
	public boolean update(Product product) {

		// SessionFactory factory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Object o = session.load(Product.class, new Integer(product.getId()));
		Product s = (Product) o;
		Transaction tx = session.beginTransaction();
		s.setViews(product.getViews());// update method will be called..
		tx.commit();
		System.out.println("Object Updated successfully.....!!");
		session.close();
		return true;
	}

	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			return this.update(product);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		Session session = sessionFactory.openSession();
		System.out.println(session);

		ProjectionList pList = Projections.projectionList();
		pList.add(Projections.property("id"), "id");
		pList.add(Projections.property("name"), "name");
		pList.add(Projections.property("code"), "code");
		pList.add(Projections.property("brand"), "brand");
		pList.add(Projections.property("description"), "description");
		pList.add(Projections.property("unitPrice"), "unitPrice");
		pList.add(Projections.property("quantity"), "quantity");
		pList.add(Projections.property("active"), "active");
		pList.add(Projections.property("categoryId"), "categoryId");
		pList.add(Projections.property("supplierId"), "supplierId");
		pList.add(Projections.property("purchases"), "purchases");
		pList.add(Projections.property("views"), "views");

		Criteria criteria = session.createCriteria(Product.class).setProjection(pList);

		@SuppressWarnings("unchecked")
		List<Product> listStdentRegDto = criteria.setResultTransformer(new AliasToBeanResultTransformer(Product.class))
				.list();

		return listStdentRegDto;

		/*
		 * Session session = sessionFactory.openSession(); String
		 * selectActiveProducts = "FROM Product WHERE active=:active"; return
		 * session.createQuery(selectActiveProducts).setParameter("active",
		 * true).list();
		 */
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		Session session = sessionFactory.openSession();
		String selectActiveProductsByCategory = "FROM Product WHERE active=:active AND categoryId=:categoryId";
		return session.createQuery(selectActiveProductsByCategory).setParameter("active", true)
				.setParameter("categoryId", categoryId).list();
	}

	@Override
	public List<Product> getLatestProducts(int count) {
		Session session = sessionFactory.openSession();
		String selectActiveProductsByCategory = "FROM Product WHERE active=:active ORDER BY id";
		return session.createQuery(selectActiveProductsByCategory).setParameter("active", true).setFirstResult(0)
				.setMaxResults(count).list();

	}

}
