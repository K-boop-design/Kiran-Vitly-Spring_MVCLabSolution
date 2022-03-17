package com.greatlearning.studentManagement.service;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.greatlearning.studentManagement.entity.Student;
@Repository
public class StudentService implements StudentService1{
	
	private SessionFactory sessionFactory;
	private Session session;
	
	public StudentService(SessionFactory sessionFactory) {
		
		try {
			session=sessionFactory.getCurrentSession();
		}catch(HibernateException e) {
			session=sessionFactory.openSession();
		}
		
	}
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		Transaction tx=(Transaction) session.beginTransaction();
		
		List<Student> students=session.createQuery("from Student").list();
		
		try {
			tx.commit();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
		
	}

	public Student findById(int id) {
		// TODO Auto-generated method stub
		Transaction tx=(Transaction) session.beginTransaction();
		Student student=session.get(Student.class, id);
		try {
			tx.commit();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

	public void save(Student student) {
		// TODO Auto-generated method stub
		Transaction tx=(Transaction) session.beginTransaction();
		session.saveOrUpdate(student);
		try {
			tx.commit();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Transaction tx=(Transaction) session.beginTransaction();
		Student student=session.get(Student.class, id);
		session.delete(student);
		try {
			tx.commit();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
