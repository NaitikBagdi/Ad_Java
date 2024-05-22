package practise_crud.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import practise_crud.model.User;

@Service
@Repository
public class UserServiceImpl implements UserServie{

	@Autowired
    private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void saveUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(user);
	}
	
	@Override
	@Transactional
	public List<User> getList(){
		Session session = sessionFactory.getCurrentSession();
	    String hql = "FROM User"; // HQL query to select all customers
	    Query<User> query = session.createQuery(hql, User.class);
	    return query.getResultList();
	}

}
