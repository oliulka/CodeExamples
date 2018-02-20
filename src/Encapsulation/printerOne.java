package Encapsulation;

public class printerOne {

	public static void main(String[] args) {
		
		
		Printer myPrinter = new Printer(0, 0, true);
		myPrinter.fillUpToner(90);
		myPrinter.printPage(5);
		System.out.println("Toner level - "+ myPrinter.getTonerLevel());
		System.out.println("N printed pages - "+ myPrinter.getNumberOfPages());
		myPrinter.fillUpToner(40);
		myPrinter.printPage(3);
		System.out.println("Toner level - "+ myPrinter.getTonerLevel());
		System.out.println("N printed pages - "+ myPrinter.getNumberOfPages());
		System.out.println("Current printer is duplex - "+ myPrinter.isDuplexPrinter());

	}

}
