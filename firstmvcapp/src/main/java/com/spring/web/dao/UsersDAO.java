package com.spring.web.dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.web.entity.Users;
@Repository
public class UsersDAO
{
SessionFactory sessionFactory;
@Autowired
public UsersDAO(SessionFactory sessionFactory)
{
this.sessionFactory=sessionFactory;
}
public boolean searchUser(Users u)
{
Session session = sessionFactory.openSession();
Query qry = session.createQuery("from Users u where u.username=? and u.password=?");
qry.setString(0, u.getUsername());
qry.setString(1, u.getPassword());
return qry.list().size() > 0;
}
}