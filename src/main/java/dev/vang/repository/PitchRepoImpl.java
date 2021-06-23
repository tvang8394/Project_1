package dev.vang.repository;





import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.vang.models.Genre;
import dev.vang.models.Pitch;
import dev.vang.models.Type;
import dev.vang.models.Users;
import dev.vang.utils.HibernateUtil;

public class PitchRepoImpl implements PitchRepo {

	public static void main(String[] args) {
		PitchRepo pr = new PitchRepoImpl();
		UserRepo ur = new UserRepoImpl();
//		Type t = new Type();
//		Genre g = new Genre();
//		t.setTypeId(1);
//		t.setType("novel");
//		g.setGenreId(1);
//		g.setGenre("manga");
//		
		
		Users u = ur.getUserById(7);
		Pitch p = pr.getPitchById(1);
		p.setAssistantApproval(true);
//		System.out.println(pr.getAllPitch());
//		pr.createPitch(p);
		pr.updatePitch(p);
		
//		p = pr.getPitchById(1);
//		System.out.println(p);
	}
	@Override
	public Pitch getPitchById(Integer id) {
		Session s = HibernateUtil.getSession();
		
		Pitch p = s.get(Pitch.class, 1);
		s.close();
		return p;
	}

	@Override
	public void createPitch(Pitch p) {
		Session s = HibernateUtil.getSession();
		
		try {
			s.beginTransaction();
			s.save(p);
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
	public void updatePitch(Pitch p) {
		//works
		Session s = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			System.out.println(p);
			tx = s.beginTransaction();
			s.update(p);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		
	}

	@Override
	public void deletePitch(Pitch p) {
		Session s = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = s.beginTransaction();
			s.delete(p);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		
	}
	@Override
	public List<Pitch> getAllPitch() {
		Session s = HibernateUtil.getSession();
		List<Pitch> pitch = null;
		
		try {
			pitch = s.createQuery("FROM pitch").list();
			System.out.println(pitch);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return pitch;
		
	}
	@Override
	public List<Pitch> getAllPitchByUser(Integer user_id) {
		Session s = HibernateUtil.getSession();
		List<Pitch> pitch = null;
		
		try {
			pitch = s.createQuery("FROM pitch where id=" + user_id).list();
			System.out.println(pitch);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return pitch;
	}
	
}
