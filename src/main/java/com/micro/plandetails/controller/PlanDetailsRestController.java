package com.micro.plandetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.micro.plandetails.model.PlanDTO;
import com.micro.plandetails.service.IPlanService;

@RestController
public class PlanDetailsRestController {

	@Autowired
	IPlanService planService;
	
	//get all plans
	@GetMapping(value = "/browsePlans", produces = "application/json")
	public ResponseEntity<List<PlanDTO>> searchAllPlans()
	{
		return new ResponseEntity<List<PlanDTO>>(this.planService.getAllPlans(),HttpStatus.OK);
	}
	
	//get specific plan with given planId
	@GetMapping(value = "/{planId}", produces = "application/json")
	public ResponseEntity<PlanDTO> searchSpecificPlanById(@PathVariable String planId)
	{
		return new ResponseEntity<PlanDTO>(this.planService.getPlanById(planId),HttpStatus.OK);
	}
}
