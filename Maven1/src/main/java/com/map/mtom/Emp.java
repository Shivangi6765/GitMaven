package com.map.mtom;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Emp {

	@Id
	private int eid;
	private String name;
	@ManyToMany
	@JoinTable(name = "emp_pro", joinColumns = { @JoinColumn(name = "e_id") }, inverseJoinColumns = {
			@JoinColumn(name = "p_id") })
	private List<Project> project;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	public Emp(int eid, String name, List<Project> project) {
		super();
		this.eid = eid;
		this.name = name;
		this.project = project;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

}
