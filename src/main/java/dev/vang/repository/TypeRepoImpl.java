package dev.vang.repository;

import org.hibernate.Session;

import dev.vang.models.Type;
import dev.vang.utils.HibernateUtil;

public class TypeRepoImpl implements TypeRepo {

	public static void main(String[] args) {
		TypeRepo tr = new TypeRepoImpl();
		
		System.out.println(tr.getTypeById(1));
	}
	@Override
	public Type getTypeById(Integer id) {
		Session s = HibernateUtil.getSession();
		s.beginTransaction();
		Type t = s.get(Type.class, id);
		s.close();
		return t;
	}

}
