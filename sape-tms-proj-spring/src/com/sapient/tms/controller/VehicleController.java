package com.sapient.tms.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.tms.model.bean.Vehicle;
import com.sapient.tms.model.bl.CentralLogic;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String routeToMethod() {
		return "insert";
	}
	
	@RequestMapping("/insert")
	public ModelAndView insertVehicle(Vehicle vehicle, BindingResult result){
		if(result.hasErrors()) {
			return new ModelAndView("db/vehicle/Insert");
		}
		CentralLogic centralLogic = new CentralLogic();
		ModelAndView mv = new ModelAndView("admin");
		try {
			boolean check = centralLogic.insertVehicle(vehicle);
			if(check) {
				mv.addObject("status", "Insert successful");
			}
			else {
				mv.addObject("status", "Insert failed");
			}
			return mv;
		}
		catch(SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
			mv.addObject("status", "Insert failed");
			return mv;
		}
	}
	
	@RequestMapping("/search")
	public ModelAndView searchVehicle(@ModelAttribute("vehicle")Vehicle vehicle){
		CentralLogic centralLogic = new CentralLogic();
		ModelAndView mv = new ModelAndView("admin");
		try {
			vehicle = centralLogic.searchVehicle(vehicle.getId());
			if(vehicle != null) {
				mv.setViewName("db/vehicle/SearchResult");
				mv.addObject("vehicle", vehicle);
			}
			else {
				mv.addObject("status", "Record does not exist");
			}
			return mv;
		}
		catch(SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
			mv.addObject("status", "Search failed");
			return mv;
		}
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteVehicle(@ModelAttribute("vehicle")Vehicle vehicle){
		CentralLogic centralLogic = new CentralLogic();
		ModelAndView mv = new ModelAndView("admin");
		try {
			boolean check = centralLogic.deleteVehicle(vehicle.getId());
			if(check) {
				mv.addObject("status", "Delete successful");
			}
			else {
				mv.addObject("status", "Record does not exist");
			}
			return mv;
		}
		catch(SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
			mv.addObject("status", "Delete failed");
			return mv;
		}
	}
	
	@RequestMapping("/update")
	public ModelAndView updateVehicle(@ModelAttribute("vehicle")Vehicle vehicle){
		CentralLogic centralLogic = new CentralLogic();
		ModelAndView mv = new ModelAndView("admin");
		try {
			boolean check = centralLogic.updateVehicle(vehicle.getId(), vehicle);
			if(check) {
				mv.addObject("status", "Update successful");
			}
			else {
				mv.addObject("status", "Record does not exist");
			}
			return mv;
		}
		catch(SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
			mv.addObject("status", "Update failed");
			return mv;
		}
	}
	
	@RequestMapping("/displayAll")
	public String displayAllVehicles(ModelMap modelMap){
		CentralLogic centralLogic = new CentralLogic();
		try {
			List<Vehicle> vehicles = centralLogic.displayAllVehicles();
			modelMap.addAttribute("vehicles", vehicles);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
			modelMap.addAttribute("status", "Operation failed");
			return "admin";
		}
		return "db/vehicle/DisplayAllResult";
	}
	
	@RequestMapping("/InsertForm")
	public ModelAndView routeToInsertForm(){
		return new ModelAndView("db/vehicle/Insert","vehicle",new Vehicle());
	}
	
	@RequestMapping("/DeleteForm")
	public ModelAndView routeToDeleteForm(){
		return new ModelAndView("db/vehicle/Delete","vehicle",new Vehicle());
	}
	
	@RequestMapping(value="/UpdateForm")
	public ModelAndView routeToUpdateForm(){
		return new ModelAndView("db/vehicle/Update","vehicle",new Vehicle());
	}
	
	@RequestMapping(value="/SearchForm")
	public ModelAndView routeToSearchForm(){
		return new ModelAndView("db/vehicle/Search","vehicle",new Vehicle());
	}
	
}
