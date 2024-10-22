package com.team.ecobuilders.preest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.ecobuilders.preest.dao.IpreestDAO;

@Service
public class PreestService {
	@Autowired
	IpreestDAO dao;

}
