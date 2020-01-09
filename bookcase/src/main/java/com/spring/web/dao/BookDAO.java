package com.spring.web.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.web.entity.Book;
@Repository
public class BookDAO 
{
	SessionFactory sessionFactory;
	@Autowired
	public BookDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		
	}
	public void insertBook(Book b)
	{
		Session session = sessionFactory.openSession();
		session.save(b);
		session.beginTransaction().commit();
	}
	public void deleteBook(int id)
	{
		Session session = sessionFactory.openSession();
		Book b = session.get(Book.class,id);
		session.delete(b);
		session.beginTransaction().commit();
	}
	public void modifyBook(Book b)
	{
	
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.update(b);
		trans.commit();
	}
	public Book getBook(int id)
	{
		Session session = sessionFactory.openSession();
		return session.get(Book.class,id);
		
	}

}
