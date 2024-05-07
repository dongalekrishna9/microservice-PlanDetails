package com.micro.plandetails.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.micro.plandetails.entity.Plan;
import com.micro.plandetails.repository.PlanRepository;
//@Component
public class MyRunner implements CommandLineRunner {

	@Autowired
	PlanRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Plan p1=new Plan();
		p1.setPlanId("PLN-144");
		p1.setPlanName("Diwali Offer");
		p1.setDescription("Free sms Free call 2GB DATA");
		p1.setValidity(45);
		
		Plan p2=new Plan();
		p2.setPlanId("PLN-212");
		p2.setPlanName("Special One day Offer");
		p2.setDescription("Free sms Free call 20GB DATA");
		p2.setValidity(35);
		
		Plan p3=new Plan();
		p3.setPlanId("PLN-555");
		p3.setPlanName("Corona Offer");
		p3.setDescription("Free Internet");
		p3.setValidity(60);
		
		Plan p4=new Plan();
		p4.setPlanId("PLN-656");
		p4.setPlanName("Free Fanda");
		p4.setDescription("All Calls and Sms Free");
		p4.setValidity(20);
		
		repo.save(p1);
		repo.save(p2);
		repo.save(p3);
		repo.save(p4);
		

	}

}
