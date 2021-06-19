package dev.vang.repository;





import java.time.LocalDate;

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
		Type t = new Type();
		Genre g = new Genre();
		t.setTypeId(1);
		t.setType("novel");
		g.setGenreId(1);
		g.setGenre("manga");
		LocalDate ld = LocalDate.now();
		
		Users u = ur.getUserById(2);
		Pitch p = new Pitch(u, "myhero", ld, t,g, "Believe It!", "Nina Wars", "none");
		pr.createPitch(p);
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
		// TODO Auto-generated method stub
		
	}
	
}
