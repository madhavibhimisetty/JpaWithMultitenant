package com.omniwyse.springdatajpa.all;

import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.NamingException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.s3.event.S3EventNotification;

public class DemoApplication {
	//public String handleRequest(S3EventNotification input, Context context) throws NamingException, SQLException {
	public static void main(String[] args) throws NamingException, SQLException {
		Emp emp = new Emp();
		emp.setEno(111);
		emp.setName("successfull");

		emp.setCreatedon(new Timestamp(new java.util.Date().getTime()));
		emp.setModifiedon(new Timestamp(new java.util.Date().getTime()));

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.omniwyse.springdatajpa.all");
		ctx.refresh();
		UserService us = ctx.getBean(UserService.class);
		us.insert(emp);
		//return "successfully inserted";

	}
}