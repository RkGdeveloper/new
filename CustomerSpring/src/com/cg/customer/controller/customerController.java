package com.cg.customer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.customer.model.Customer;
import com.cg.customer.service.ICustomerService;

@Controller
public class customerController {

	@Autowired
	ICustomerService service;
	
	
	@RequestMapping("/index")
	public String goToIndex(){
		return "index";
	}
	
	@RequestMapping("/start")
	public String goToStart(Model model){

		model.addAttribute("customer", new Customer());
		return "customerRegForm";
	}
	
	@RequestMapping("/reg")
	public String registration(@ModelAttribute("customer") @Valid Customer customer,BindingResult result, Model model){
		
		if(result.hasErrors())
		{
			return "customerRegForm";
		}
		else{
			service.addDetails(customer);
			model.addAttribute("k", customer);
			return "customerSuccess";
		}
	}
	
	@RequestMapping("/goFind")
	public ModelAndView goToFind(){
		
		List<Integer> idList= service.retrieveIds();
		return new ModelAndView("custIdFind", "idList", idList);
	}
	
	@RequestMapping("/find")
	public ModelAndView findById(@RequestParam("customerid") int custId){
	
		Customer cust = service.retrieveById(custId);
		return new ModelAndView("customerSuccess", "k", cust);
	}
	
	
	@RequestMapping("/goFindAll")
	public ModelAndView findAll(){
		
		List<Customer> custList = service.retrieveDetails();
		return new ModelAndView("customerListSuccess", "list", custList);
	}
	
	
	@RequestMapping("/goDelete")
	public ModelAndView goToDelete(Model model){
		
		List<Integer> idList= service.retrieveIds();
		return new ModelAndView("custIdDelete", "idList", idList);
	}
	
	@RequestMapping("/delete")
	public String deleteById(@RequestParam("customerId") int custId, Model model){
		/*Customer cust = service.retrieveById(custId);
		service.deleteDetails(cust);*/
		
		service.deleteCustomer(custId);
		model.addAttribute("custId", custId);
		return "deleteCust";
	}
	
	@RequestMapping("/goUpdate")
	public ModelAndView goToUpdate(Model model){
		
		List<Integer> idList= service.retrieveIds();
		return new ModelAndView("custIdUpdate", "idList", idList);
	}
	
	@RequestMapping("/update")
	public String updateById(@RequestParam("customerid") int custId, Model model){
	
		Customer customer = service.retrieveById(custId);
		model.addAttribute("customer", customer);
		return "updateCust";
	}
	
	@RequestMapping("/doUpdate")
	public String updateDetails(@ModelAttribute("customer") @Valid Customer cust,BindingResult result, Model model){
		
		if(result.hasErrors())
		{
			return "updateCust";
		}
		else{
			Customer customer = service.update(cust);
			model.addAttribute("k", customer);
			return "customerSuccess";
		}
	}
}
	
	
