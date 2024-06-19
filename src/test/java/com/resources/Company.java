package com.resources;

public class Company {
	
	 String name;
	 int salary;
	 static String companyName = "TCS";
	 
	 public static void main(String[] args) {
		
		 Company rahul = new Company("Rahul", 80000);
		 rahul.testing();
		 
		 Company sachin = new Company("Sachin", 90000);
		 sachin.testing();
	}
	 
	
	public Company(String s , int n) {
		name = s;
		salary = n;
	}
	 
	 
	 public void testing() {
		 
		 System.out.println(companyName);
		 System.out.println(name);
		 System.out.println(salary);
		 
		 
	 }

}
