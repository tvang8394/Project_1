package dev.vang.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import dev.vang.models.Genre;
import dev.vang.utils.HibernateUtil;

public class GenreRepoImpl implements GenreRepo {
	public static void main(String[] args) {
		GenreRepo gr = new GenreRepoImpl();
		
		System.out.println(gr.getGenreById(1));
	}
	@Override
	public Genre getGenreById(Integer id) {
		Session s = HibernateUtil.getSession();
		
		Genre g = s.get(Genre.class, 1);
		s.close();
		return g;
	}
	@Override
	public List<Genre> getAllGenre() {
		Session s = HibernateUtil.getSession();
		List<Genre> genre = null;
		
		try {
			genre = s.createQuery("FROM genre").list();
			System.out.println(genre);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return genre;
	}

}
