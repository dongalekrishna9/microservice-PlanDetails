package com.micro.plandetails.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.plandetails.entity.Plan;
import com.micro.plandetails.model.PlanDTO;
import com.micro.plandetails.repository.PlanRepository;
import com.micro.plandetails.service.IPlanService;
@Service
public class PlanServiceImpl implements IPlanService {

	@Autowired
	PlanRepository planRepo;
	
	@Override
	public List<PlanDTO> getAllPlans() {		
		List<Plan> planList = this.planRepo.findAll();
		
		List<PlanDTO> planDTOList=new ArrayList<PlanDTO>();
		planList.forEach(plan->{
			PlanDTO planDTO=new PlanDTO();
			BeanUtils.copyProperties(plan, planDTO);
			planDTOList.add(planDTO);
		});
		
		return planDTOList;
	}

	@Override
	public PlanDTO getPlanById(String planId) {
		
		Optional<Plan> optional = this.planRepo.findById(planId);
		if(optional.isPresent())
		{
			Plan plan = optional.get();
			PlanDTO planDTO=new PlanDTO();
			BeanUtils.copyProperties(plan, planDTO);
			return planDTO;
		}
		else
		{
			return null;
		}		
		
	}

}
