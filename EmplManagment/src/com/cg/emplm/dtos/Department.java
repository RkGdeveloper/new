package com.cg.emplm.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name="dept_master")
@NamedQueries(@NamedQuery(name = "getAllIds", query = "SELECT dept.id FROM Department dept"))
public class Department implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String name;
	
	@OneToMany(mappedBy="department",cascade=CascadeType.ALL)
	private Set<Employee> employees = new HashSet<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name ;
	}
	
	
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	//the method below will add employee to department 
	//also serves the purpose to avoid cyclic references. 
	public void addEmployee(Employee employee) {
		employee.setDepartment(this);			//this will avoid nested cascade
		this.getEmployees().add(employee);
	}
	
}
