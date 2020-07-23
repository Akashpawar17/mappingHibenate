package com.capgemini.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	private int sid;
	private String sname;
	private int marks;
	/*@OneToOne
	private Laptop laptop;*/
	

	@OneToMany(mappedBy="student")
	private List<Laptop> laptop = new ArrayList<Laptop>();
	
	/*@ManyToMany(mappedBy="student")
	private List<Laptop> laptop = new ArrayList<Laptop>();
	*/


	public  List<Laptop> getLaptop() {
		return laptop;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = (List<Laptop>) laptop;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", marks=" + marks + ", laptop=" + laptop + "]";
	}


	

}
