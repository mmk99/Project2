package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private SessionFactory sessionFactory;

		public User registerUser(User user) {
	        Session session=sessionFactory.openSession();
	        session.save(user);
	        session.flush();
	        session.close();
	        return user;
		}

		public User login(User user) {
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from User where username=? and password=?");
			query.setString(0,user.getUsername());
			query.setString(1,user.getPassword());
			User validUser=(User)query.uniqueResult();
			return validUser;
			
		}
		public void updateUser(User user) {
			Session session=sessionFactory.openSession();
			//update user_info set username=?,password=?,email=?,enabled=?,online=? where id=?
			session.update(user);
			session.flush();
			session.close();
		}
		public User getUser(int id) {
			Session session=sessionFactory.openSession();
			User user=(User)session.get(User.class, id);
			session.close();
			return user;
		}

		public List<String> getOnlineUsers() {
		        Session session=sessionFactory.openSession();
		        Query query=session.createQuery("select username from User where online=1");
		        List<String> onlineUsers=query.list();
		        session.close();
		        return onlineUsers;
		    }	
			
}
