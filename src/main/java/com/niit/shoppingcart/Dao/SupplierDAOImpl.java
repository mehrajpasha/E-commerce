package com.niit.shoppingcart.Dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Supplier;

@Repository("supplierDAO")
@SuppressWarnings("deprecation")
public class SupplierDAOImpl  implements SupplierDAO{
	@Autowired
	private SessionFactory sessionFactory;
	public SupplierDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	//save -save the record - if the record exist it will throw error
	//update - update the record - if the record does not exist, it will throw error
	//save or update - if the record exist, it will update
	//                 - if the record does not exist it will create
	@Transactional
	public boolean saveOrUpdate(Supplier supplier){
		try {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		return true;
		} catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Transactional
		public boolean delete(Supplier supplier){
			try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
			} catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
			
	}
	@Transactional
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public Supplier get(int id){
			// select* from supplier where id='101'
			String hql = "from Supplier where id="+"'"+id+"'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			List<Supplier> list = query.list();
			if(list==null){
				return null;
			} else {
				return list.get(0);
			}
		}
	@Transactional
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public List<Supplier> list() {
			String hql = "from Supplier";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			List<Supplier> list = query.list();
			return list;
		}
			
		
		
}
