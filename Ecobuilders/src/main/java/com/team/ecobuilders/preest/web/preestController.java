package com.team.ecobuilders.preest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.ecobuilders.preest.service.PreestService;

@Controller
public class preestController {
	@Autowired
	PreestService ps;

	@RequestMapping("/estStep1")
	public String estStep1() {
		return "estimate/estStep1";
	}
	
	@RequestMapping("/estStep2")
	public String estStep2() {
		return "estimate/estStep2";
	}
}
