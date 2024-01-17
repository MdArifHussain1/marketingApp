package com.marketingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.entities.Lead;
import com.marketingapp.services.LeadService;
import com.marketingapp.util.EmailService;

@Controller
public class LeadController {
	
	@Autowired
	private EmailService emailServ;
	
	@Autowired
	private LeadService leadServ;
	
	
	@RequestMapping("/viewCreateLead")
	public String viewCreateLead() {
		return "create_lead";
	}
	
	@RequestMapping("/saveLead")
	public String saveLead(@ModelAttribute("leads") Lead l, Model map) {
		leadServ.saveOneLead(l);
		emailServ.sendSimpleMail(l.getEmail(), "Email Test", "Hiii I am Arif Khan and i am just checking to send an email through program");
		map.addAttribute("msg", "Your Lead is saved!!!");
		return "create_lead";
	}
	@RequestMapping("/readLead")
	public String readLead(Model map) {
		List<Lead> leads = leadServ.listAll();
		map.addAttribute("leads", leads);
		return "lead_list";
		
	}
	
	@RequestMapping("/deleteLead")
	public String deleteLead(@RequestParam("id") int id, Model map) {
		leadServ.deletOneLead(id);
		List<Lead> leads = leadServ.listAll();
		map.addAttribute("leads", leads);
		return "lead_list";
	}
	
	@RequestMapping("/updateLead")
	public String updateLead(@RequestParam("id") int id, Model map) {
		Lead upLead = leadServ.updateOneLead(id);
		map.addAttribute("lead", upLead);		
		return "update_lead";		
	}
	
	@RequestMapping("/updateOneLead")
	public String updateOneLead(@ModelAttribute("leads") Lead l, Model map) {
		leadServ.saveOneLead(l);
		List<Lead> leads = leadServ.listAll();
		map.addAttribute("leads", leads);
		return "lead_list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
//Second Approach to data save into DB	
//	@RequestMapping("/saveLead")
//	public String saveLead(@RequestParam("firstName") String fn,@RequestParam("lastName") String ln,@RequestParam("email") String em,@RequestParam("mobile") String mo) {
//		Lead l2=new Lead();
//		l2.setFirstName(fn);
//		l2.setLastName(ln);
//		l2.setEmail(em);
//		l2.setMobile(mo);
//		leadServ.saveOneLead(l2);
//		return "create_lead";
//	}
	
	
//Third Approach to data save into DB	
//	@RequestMapping("/saveLead")
//	public String saveLead(OneLead ol) {
//		Lead l3=new Lead();
//		l3.setFirstName(ol.getFirstName());
//		l3.setLastName(ol.getLastName());
//		l3.setEmail(ol.getEmail());
//		l3.setMobile(ol.getMobile());
//		leadServ.saveOneLead(l3);
//		return "create_lead";
//	}
//	
	
}
