package com.oliulka.simple;

public class Employee {

	String Name;
	int age;
	String departament;
	String jobTitle;
	int salary;
	boolean topPerformer;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public boolean isTopPerformer() {
		return topPerformer;
	}
	public void setTopPerformer(boolean topPerformer) {
		this.topPerformer = topPerformer;
	}
	public String getDepartment(){
		return departament;
	}
	public void setDepartment(String department){
		this.departament = department;
	}
	
}
