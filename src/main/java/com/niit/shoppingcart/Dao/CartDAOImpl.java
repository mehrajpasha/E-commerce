package com.niit.shoppingcart.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Cart;

@Repository("CartDAO")
public class CartDAOImpl implements CartDAO  {



	
		@Autowired
		private SessionFactory sessionFactory;
		public CartDAOImpl(SessionFactory sessionFactory){
			this.sessionFactory = sessionFactory;
		}
		
		@Transactional
		public boolean saveOrUpdate(Cart cart){
			try {
				sessionFactory.getCurrentSession().saveOrUpdate(cart);
				return true;
			} catch (HibernateException e) {
				e.printStackTrace();
			return false;
			}
		}
		
		@Transactional
		public boolean delete(Cart cart){
			try {
				sessionFactory.getCurrentSession().delete(cart);
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			return true;
		}
		
		@Transactional
		public Cart get(int cartid){
			String hql = "from Cart where productid=" + "'" +cartid +"'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Cart> listCart = (List<Cart>)query.list();
			if(listCart!= null && !listCart.isEmpty()){
				return listCart.get(0);
			}
			return null;
			}
		
		
		
		
		@Transactional
      public List<Cart> list(){
			@SuppressWarnings("unchecked")
			List<Cart> listCart = (List<Cart>)
			sessionFactory.getCurrentSession()
			.createCriteria(Cart.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return listCart;
			}
		
		@Transactional
		public Cart checkproduct(int id)
		{
			String hql= "from Cart where productid="+id ;
			Query query=sessionFactory.getCurrentSession().createQuery(hql);				
				@SuppressWarnings("unchecked")
				List<Cart> list = (List<Cart>) query.list();
				if (list!= null && !list.isEmpty()) {
		return list.get(0);
				}
				return null;
		}

		@Transactional
		public long getsize(int id) {
			Criteria c=sessionFactory.getCurrentSession().createCriteria(Cart.class);
			c.add(Restrictions.eq("userid", id));
			c.add(Restrictions.eq("Status","C"));
			c.setProjection(Projections.count("userid"));
			long count=(long) c.uniqueResult();
			return count;
		}
		@SuppressWarnings("unchecked")
		@Transactional
		public Cart get(int prodid, int userid) {
			String hql = "from"+" Cart"+" where Status='C'and userid="+userid+" and productid="+prodid;
			@SuppressWarnings("rawtypes")
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			List<Cart> list = (List<Cart>) query.list();
			if (list!= null && !list.isEmpty()) {
				return list.get(0);
			}
			return null;
		}

		@Transactional
		public long CartPrice(int userid) {
			Criteria c=sessionFactory.getCurrentSession().createCriteria(Cart.class);
			c.add(Restrictions.eq("userid", userid));
			c.add(Restrictions.eq("Status","C"));
			c.setProjection(Projections.sum("price"));
			Long l= (Long) c.uniqueResult();
			return l;
		}

		

	}
		
		
		
		


