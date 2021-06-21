package dev.vang.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.vang.models.Genre;
import dev.vang.models.Users;
import dev.vang.utils.HibernateUtil;

public class UserRepoImpl implements UserRepo {

	public static void main(String[] args) {
		UserRepo ur = new UserRepoImpl();
		Genre g = new Genre();
		g.setGenre("manga");
		g.setGenreId(1);
		Users u = new Users("mot","vang", "tcvaj", "password", "assistant", g);
		ur.createUser(u);
//		u = ur.getUserById(2);
//		System.out.println(u);
//		u = ur.getByUserandPass("tcvaj", "password");
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
	@Override
	public Users getByUserandPass(String username, String password) {
		Session s = HibernateUtil.getSession();
		Users u = null;
		try {
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Users> cr = cb.createQuery(Users.class);
			Root<Users> root = cr.from(Users.class);
			Predicate p1 = cb.equal(root.get("userName"), username);
			Predicate p2 = cb.equal(root.get("password"), password);
			cr.select(root).where(cb.and(p1,p2));
			u = s.createQuery(cr).getSingleResult();
			return u;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return u;
		
	}
	
}
