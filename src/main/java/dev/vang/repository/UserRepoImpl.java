package dev.vang.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.vang.models.Users;
import dev.vang.utils.HibernateUtil;

public class UserRepoImpl implements UserRepo {

	public static void main(String[] args) {
		UserRepo ur = new UserRepoImpl();
		Users u = new Users("mot","vang", "tcvaj", "password", "assistant", "manga");
//		ur.createUser(u);
		u = ur.getUserById(2);
		System.out.println(u);
		
	}
	@Override
	public Users getUserById(Integer id) {
		//works
		Session s = HibernateUtil.getSession();
		
		Users c = s.get(Users.class, id);
		
		s.close();
		return c;
	}

	@Override
	public void updateUser(Users u) {
		//works
		Session s = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = s.beginTransaction();
			s.update(u);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}

		
	}

	@Override
	public void createUser(Users u) {
		
		Session s = HibernateUtil.getSession();
		
		try {
			s.beginTransaction();
			s.save(u);
			//commit the transaction
			s.getTransaction().commit();
			
		} catch(HibernateException e) {
			e.printStackTrace();
			s.getTransaction().rollback();
		} finally {
			s.close();
		}

		
	}
	
}
