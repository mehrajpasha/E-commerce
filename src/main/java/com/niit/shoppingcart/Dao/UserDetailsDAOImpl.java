package com.niit.shoppingcart.Dao;

	import java.util.List;

	import org.hibernate.Criteria;
	import org.hibernate.Query;
	import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

	import com.niit.shoppingcart.model.UserDetails;

		@SuppressWarnings("deprecation")
		@Repository("userdetailsDAO")
		public class UserDetailsDAOImpl implements UserDetailsDAO {
			
			@Autowired
			private SessionFactory sessionFactory;
			public UserDetailsDAOImpl(SessionFactory sessionFactory){
				this.sessionFactory = sessionFactory;
			}
			@Transactional
			public boolean saveOrUpdate(UserDetails userdetails){
				try{
				sessionFactory.getCurrentSession().saveOrUpdate(userdetails);
		    	 return true;
		     }catch(Exception e){
		     e.printStackTrace();
			return false;
		}
			} 
			@Transactional
			public boolean delete(UserDetails userdetails){
			     try{
			    	 sessionFactory.getCurrentSession().delete(userdetails);
			    	 return true;
			     }catch(Exception e){
			     e.printStackTrace();
				return false;
			}
		}
			@Transactional
			public UserDetails get(int id){
				String hql = "from UserDetails where id=" + "'" +id +"'";
				Query query = sessionFactory.getCurrentSession().createQuery(hql);
				@SuppressWarnings("unchecked")
				List<UserDetails> listUserDetails = (List<UserDetails>)query.list();
				if(listUserDetails!= null && !listUserDetails.isEmpty()){
					return listUserDetails.get(0);
				}
				return null;
				}
			
			@Transactional
	      public List<UserDetails> list(){
				@SuppressWarnings("unchecked")
				List<UserDetails> listUserDetails = (List<UserDetails>)
				sessionFactory.getCurrentSession()
				.createCriteria(UserDetails.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
				return listUserDetails;
			}
	      
			@SuppressWarnings("rawtypes")
			@Transactional
			public boolean isValidUser(String username, String password) {
				Criteria c=sessionFactory.getCurrentSession().createCriteria(UserDetails.class);
				c.add(Restrictions.eq("username",username));
				c.add(Restrictions.eq("password",password));
				
				List list = c.list();
				if(list==null || list.isEmpty())
				{
					return false;
				}
				else
				{
					return true;
				}
			}
			@Transactional
			public UserDetails get1(String username) {
				Criteria c=sessionFactory.getCurrentSession().createCriteria(UserDetails.class);
				c.add(Restrictions.eq("username",username));
				
				@SuppressWarnings("unchecked")
				List<UserDetails> listUser = (List<UserDetails>) c.list();
				
				if (listUser != null && !listUser.isEmpty()) {
					return listUser.get(0);
				}
				else {
					
					return null;
				}
			}
			
				
			
			
			
			
			
	}


