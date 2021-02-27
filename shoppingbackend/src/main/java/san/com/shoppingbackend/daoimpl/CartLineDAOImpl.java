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

import san.com.shoppingbackend.dao.CartLineDAO;
import san.com.shoppingbackend.dto.Cart;
import san.com.shoppingbackend.dto.CartLine;
import san.com.shoppingbackend.dto.Product;

@Repository
@Transactional
public class CartLineDAOImpl implements CartLineDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static List<CartLine> categories = new ArrayList<CartLine>();

	@Override
	public List<CartLine> list(Integer id) {
		System.out.println("control in getStudentDetailsList daoimpl");

		Session session = sessionFactory.openSession();
		System.out.println(session);

		ProjectionList pList = Projections.projectionList();
		pList.add(Projections.property("id"), "id");
		pList.add(Projections.property("cartId"), "cartId");
		pList.add(Projections.property("productCount"), "productCount");
		pList.add(Projections.property("total"), "total");
		pList.add(Projections.property("buyingPrice"), "buyingPrice");
		pList.add(Projections.property("isAvaliable"), "isAvaliable");
		pList.add(Projections.property("product"), "product");

		Criteria criteria = session.createCriteria(CartLine.class).createAlias("product", "product")
				.setProjection(pList);

		@SuppressWarnings("unchecked")
		List<CartLine> listCartLine = criteria.setResultTransformer(new AliasToBeanResultTransformer(CartLine.class))
				// .add(Restrictions.eq("id", id))
				.list();

		return listCartLine;
	}

	@Override
	public CartLine get(int id) {
		Session session = sessionFactory.openSession();
		System.out.println(session);

		Criteria criteria = session.createCriteria(CartLine.class).createAlias("product", "product")
				.add(Restrictions.eq("id", id));

		CartLine result = (CartLine) criteria.uniqueResult();
		if (result != null) {
			CartLine genre = (CartLine) result;
			// System.out.println("Genre = " + genre.getName());
		}

		return result;

	}

	@Override

	public boolean add(CartLine cartLine) {

		Session session = null;
		Integer id = 0;
		try {

			session = sessionFactory.openSession();
			id = (Integer) session.save(cartLine);

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
		 * Session session = null; Transaction transaction = null; Integer id =
		 * 0; try { session = sessionFactory.openSession(); transaction =
		 * session.beginTransaction(); transaction.begin();
		 * 
		 * id = (Integer) session.save(category);
		 * 
		 * transaction.commit(); } catch (Exception e) { if (transaction !=
		 * null) { transaction.rollback(); } e.printStackTrace(); } finally { if
		 * (session != null) { session.close(); } } if (id != 0) { return true;
		 * } else { return false;
		 * 
		 * }
		 * 
		 */}

	@Override
	public boolean update(CartLine cartLine) {
		Session session = null;
		try {

			session = sessionFactory.openSession();
			Object o = session.load(CartLine.class, new Integer(cartLine.getId()));
			CartLine cl = (CartLine) o;
		
			Transaction tx = session.beginTransaction();
			session.update(cl);
			
			cl.setBuyingPrice(cartLine.getBuyingPrice());
			cl.setProductCount(cartLine.getProductCount());
			cl.setTotal((cartLine.getTotal()));
			tx.commit();
			System.out.println("Object Updated successfully.....!!");
			
			return true;
			/*
			 * session = sessionFactory.openSession(); session.update(cartLine);
			 * return true;
			 */
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	@Override
	public boolean delete(CartLine cartLine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CartLine> listAvailable(Integer cartId) {
		Session session = sessionFactory.openSession();
		System.out.println(session);

		ProjectionList pList = Projections.projectionList();
		pList.add(Projections.property("id"), "id");
		pList.add(Projections.property("cartId"), "cartId");
		pList.add(Projections.property("productCount"), "productCount");
		pList.add(Projections.property("total"), "total");
		pList.add(Projections.property("buyingPrice"), "buyingPrice");
		pList.add(Projections.property("isAvaliable"), "isAvaliable");
		pList.add(Projections.property("product"), "product");

		Criteria criteria = session.createCriteria(CartLine.class).createAlias("product", "product")
				.setProjection(pList);

		@SuppressWarnings("unchecked")
		List<CartLine> listStdentRegDto = criteria
				.setResultTransformer(new AliasToBeanResultTransformer(CartLine.class))
				.add(Restrictions.eq("cartId", cartId)).add(Restrictions.eq("isAvaliable", true))

				.list();

		return listStdentRegDto;
	}

	@Override
	public CartLine getByCartAndProduct(Integer cartId, Integer productId) {
		Session session = sessionFactory.openSession();
		System.out.println(session);

		ProjectionList pList = Projections.projectionList();
		pList.add(Projections.property("id"), "id");
		pList.add(Projections.property("cartId"), "cartId");
		pList.add(Projections.property("productCount"), "productCount");
		pList.add(Projections.property("total"), "total");
		pList.add(Projections.property("buyingPrice"), "buyingPrice");
		pList.add(Projections.property("isAvaliable"), "isAvaliable");
		pList.add(Projections.property("product"), "product");

		Criteria criteria = session.createCriteria(CartLine.class).createAlias("product", "product")
				.setProjection(pList);

		CartLine cartLine = (CartLine) criteria.setResultTransformer(new AliasToBeanResultTransformer(CartLine.class))
				.add(Restrictions.eq("cartId", cartId)).add(Restrictions.eq("product.id", productId)).uniqueResult();
		return cartLine;

	}

	@Override
	public boolean updateCart(Cart cart) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Object o = session.load(Cart.class, new Integer(cart.getId()));
			Cart c = (Cart) o;
			Transaction tx = session.beginTransaction();
			session.update(c);
			c.setGrandTotal(cart.getGrandTotal());
			
			tx.commit();
			System.out.println("Object Updated successfully.....!!");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
