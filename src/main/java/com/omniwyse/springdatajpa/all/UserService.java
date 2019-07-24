package com.omniwyse.springdatajpa.all;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

@Service
@Transactional
public class UserService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	
	@Autowired
	DBConfig dbconfig;
	
	@Autowired
	UserRepository userRepository;
	
	
	public long insert(Emp emp) throws NamingException, SQLException {
		MongoClient mongo = new MongoClient("ec2-3-89-218-35.compute-1.amazonaws.com", 27017);
		DB db = mongo.getDB("testdb");
		DBCollection table = db.getCollection("user");
		DBCursor cursor = table.find();
		while (cursor.hasNext()) {
			
			DetectTenant.getInstance().setTenant((String)cursor.next().get("tenant"));
		
		userRepository.save(emp);
		
		}
		return emp.getEno();
	}

	public Emp find(long eno) {
		return entityManager.find(Emp.class, eno);
	}
	
	
}