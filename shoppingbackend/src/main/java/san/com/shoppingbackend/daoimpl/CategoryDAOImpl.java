package san.com.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import san.com.shoppingbackend.dao.CategoryDAO;
import san.com.shoppingbackend.dto.Category;
import san.com.shoppingbackend.dto.Product;

@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static List<Category> categories = new ArrayList<Category>();

	@Override
	public List<Category> list() {
		System.out.println("control in getStudentDetailsList daoimpl");

		Session session = sessionFactory.openSession();
		System.out.println(session);

		ProjectionList pList = Projections.projectionList();
		pList.add(Projections.property("id"), "id");
		pList.add(Projections.property("name"), "name");
		pList.add(Projections.property("description"), "description");
		pList.add(Projections.property("imageURL"), "imageURL");
		pList.add(Projections.property("isActive"), "isActive");

		Criteria criteria = session.createCriteria(Category.class).setProjection(pList);

		List<Category> listStdentRegDto = criteria
				.setResultTransformer(new AliasToBeanResultTransformer(Category.class)).list();

		return listStdentRegDto;
	}

	@Override
	public Category get(int id) {
		Session session = sessionFactory.openSession();
		System.out.println(session);

		Criteria criteria = session.createCriteria(Category.class).add(Restrictions.eq("id", id));

		Category result = (Category) criteria.uniqueResult();
		if (result != null) {
			Category genre = (Category) result;
			System.out.println("Genre = " + genre.getName());
		}

		return result;

	}

	@Override

	public boolean add(Category category) {

		Session session = null;
		Integer id = 0;
		try {
			
			session = sessionFactory.openSession();
			id = (Integer) session.save(category);

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

	
		
		
		/*
		Session session = null;
		Transaction transaction = null;
		Integer id = 0;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			transaction.begin();

			id = (Integer) session.save(category);

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

	*/}

	@Override
	public boolean update(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

}
