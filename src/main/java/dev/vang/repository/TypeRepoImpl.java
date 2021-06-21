package dev.vang.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import dev.vang.models.Genre;
import dev.vang.models.Type;
import dev.vang.utils.HibernateUtil;

public class TypeRepoImpl implements TypeRepo {

	public static void main(String[] args) {
		TypeRepo tr = new TypeRepoImpl();
		System.out.println(tr.getAllType());
	}
	@Override
	public Type getTypeById(Integer id) {
		Session s = HibernateUtil.getSession();
		s.beginTransaction();
		Type t = s.get(Type.class, id);
		s.close();
		return t;
	}
	@Override
	public List<Type> getAllType() {
		Session s = HibernateUtil.getSession();
		List<Type> type = null;
		
		try {
			type = s.createQuery("FROM types").list();
			System.out.println(type);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return type;
	}

}
