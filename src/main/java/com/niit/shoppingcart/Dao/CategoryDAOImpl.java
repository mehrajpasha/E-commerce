package com.niit.shoppingcart.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Category;


	@Repository("categoryDAO")
	public class CategoryDAOImpl implements CategoryDAO {
		
		@Autowired
		private SessionFactory sessionFactory;
		public CategoryDAOImpl(SessionFactory sessionFactory){
			this.sessionFactory = sessionFactory;
		}
		
		@Transactional
		public boolean saveOrUpdate(Category category){
			try {
				sessionFactory.getCurrentSession().save(category);
				return true;
			} catch (HibernateException e) {
				e.printStackTrace();
			return false;
			}
		}
		
		@Transactional
		public boolean delete(Category category){
			try {
				sessionFactory.getCurrentSession().delete(category);
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			return true;
		}
		
		@Transactional
		public Category get(int id){
			String hql = "from Category where id=" + "'" +id +"'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Category> listCategory = (List<Category>)query.list();
			if(listCategory!= null && !listCategory.isEmpty()){
				return listCategory.get(0);
			}
			return null;
			}
		
		@Transactional
      public List<Category> list(){
			@SuppressWarnings("unchecked")
			List<Category> listCategory = (List<Category>)
			sessionFactory.getCurrentSession()
			.createCriteria(Category.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return listCategory;
			}

	}
		
		
		
		


