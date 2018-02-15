package employee;

public class MyEmployee {
	
	public static void main(String args[]){
		
	Employee myGuy = new Employee();
	myGuy.setName("Alex");
	myGuy.setAge(23);
	myGuy.setJobTitle("SDET");
	myGuy.setSalary(120000);
	myGuy.setTopPerformer(true);
	myGuy.setDepartment("QA");
	System.out.println("Here is my guy!"+myGuy.getName() +"His age is" +myGuy.getAge() + myGuy.getDepartment());
	}
	

}
