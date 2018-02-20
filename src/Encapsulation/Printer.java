package Encapsulation;

public class Printer 
{
	private int tonerLevel;
	private int NumberOfPages;
	private boolean duplexPrinter;
	
	public Printer(int tonerLevel, int NumberOfPages, boolean duplexPrinter){
		this.tonerLevel=tonerLevel;
		this.NumberOfPages=NumberOfPages;
		this.duplexPrinter = duplexPrinter;
	}
	
	public int getTonerLevel(){
		return tonerLevel;
	}
	public int getNumberOfPages() {
		return NumberOfPages;
	}
	public boolean isDuplexPrinter() {
		return duplexPrinter;
	}
	
	public int fillUpToner(int tonerLevelChange)
	{
		if(tonerLevelChange>0 && tonerLevelChange<=100)
		{
			this.tonerLevel += tonerLevelChange;
			if (tonerLevel>100)
			{ 	tonerLevel = 100; 
				System.out.println("Your toner is full!"); 
			}
			if (tonerLevel<0)
			{ 	tonerLevel = 0; 
				System.out.println("You are out of toner!"); }
			
		}
		else
		{
			System.out.println("Passed parametr is over a 100%");
			return -1;	
		}
		return tonerLevel;
		
	}
	
	public int printPage (int pagesPrinted)
	{
		NumberOfPages+=pagesPrinted;
		return NumberOfPages;
	}
}
