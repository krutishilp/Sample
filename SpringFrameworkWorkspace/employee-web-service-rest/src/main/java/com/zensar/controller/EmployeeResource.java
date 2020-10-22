package com.zensar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.model.Employee;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = {"http://localhost:4200"})
public class EmployeeResource {
	List<Employee> list=new ArrayList<Employee>();
	
	public EmployeeResource() {
		list.add(new Employee(1001,"Krutishil","123456"));
		list.add(new Employee(1002,"Shivam","13336"));
		list.add(new Employee(1003,"Deepak","112122"));
		list.add(new Employee(1004,"Kuldeep","55551"));
		list.add(new Employee(1005,"Rahul","545555"));
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return list;
	}
	@PostMapping("/employees")
	public void insertEmployee(@RequestBody Employee employee) {
		list.add(employee);
	}
	
	@DeleteMapping(path ="/employees/{Id}")
	public void deleteEmployee(@PathVariable("Id") int Id) {
		//System.out.println("WEEEEEEEEEEEEEEEEEEEEEEE");
		for(Employee e:list) {
			if(e.getId()==Id) {
				list.remove(e);
				break;
			}
		}
	}
	
	@GetMapping(path ="/employees/{Id}")
	public Employee getEmployee(@PathVariable("Id") int Id) {
		//System.out.println("WEEEEEEEEEEEEEEEEEEEEEEE");
		for(Employee e:list) {
			if(e.getId()==Id) {
				return e;
			}
		}
		return null;
	}
}
