package service.serviceimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import model.Student;
import service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Student saveStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.save(student);
		return student;
	}

}
