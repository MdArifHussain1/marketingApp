package com.marketingapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp.entities.Lead;
import com.marketingapp.repository.LeadRepository;
@Service
public class LeadServiceImpl implements LeadService {
	
	@Autowired
	private LeadRepository leadRepo;
	
	
	@Override
	public void saveOneLead(Lead l) {
		leadRepo.save(l);
	}


	@Override
	public List<Lead> listAll() {
		List<Lead> lead = leadRepo.findAll();
		return lead;
	}


	@Override
	public void deletOneLead(int id) {
		leadRepo.deleteById(id);
	}


	@Override
	public Lead updateOneLead(int id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}

}
