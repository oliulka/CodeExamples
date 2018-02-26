package com.oliulka.oop.polymorphism;

// Create a base class called Car
// It should have a few fields that would be appropriate for a generice car calss.
// engine, cylinders, wheels, etc.
// Constructor should initialize cylinders (number of) and name, and set wheels to 4
// and engine to true. Cylinders and names would be passed parameters.
//
// Create appropriate getters
//
// Create some methods like startEngine, accelerate, and brake
//
// show a message for each in the base class
// Now create 3 sub classes for your favorite vehicles.
// Override the appropriate methods to demonstrate polymorphism in use.

class Car {
	
	private String name;
	private String color;
	private int cylinders;
	private int wheels;
	private boolean engine;
	protected int speed;
	

	public Car(String name, int cylinders) {
		this.engine = true;
		this.wheels = 4;
		this.speed = 0;
		this.name = name;
		this.cylinders = cylinders;
	}
	
	public void startEngine(){
		if (!engine){
			this.engine=true;
			System.out.println("Base car engine is running now!");
		}
		else
		{
			System.out.println("Base car engine is already running!");
		}
	}
	
	public int Accelerate (int speedUp){
		this.speed += speedUp;
		System.out.println("Base car speed up worked, current speed - " + this.speed);
		if (speed >=0)
		{	
			return speed;
		}
		else
		{
			return -1;
		}
	}
	
	public int slowDown (int speedDown){
		this.speed -= speedDown;
		System.out.println("Base car slow down worked, current speed - " + this.speed);
		if (speed >=0)
		{	
			return speed;
		}
		else
		{
			return -1;
		}
	}
	
}

class Porsche extends Car{

	public Porsche() {
		super("Panamera", 6);
	}
	
	@Override
	public int Accelerate (int speedUp){
		this.speed += speedUp;
		System.out.println("Porsche speeds up like a rocket, current speed - " + this.speed);
		return speed;
	}
	
	@Override
	public int slowDown (int speedDown){
		this.speed -= speedDown;
		System.out.println("Porsche slows down fast, current speed - " + this.speed);
		return speed;
	}
	
}

class Mercedes extends Car {

	public Mercedes() {
		super("S-class", 8);
	}
	
	@Override
	public int Accelerate (int speedUp){
		this.speed += speedUp;
		System.out.println("Mercedes speeds up , current speed - " + this.speed);
		return speed;
	}
	
	@Override
	public int slowDown (int speedDown){
		this.speed += speedDown;
		System.out.println("Mercedes slows down fast, current speed - " + this.speed);
		return speed;
	}
	
}

class Audi extends Car {

	public Audi() {
		super("A5", 8);
	}
	
	@Override
	public int Accelerate (int speedUp){
		this.speed += speedUp;
		System.out.println("Audi speeds up, current speed - " + this.speed);
		return speed;
	}
	
	@Override
	public int slowDown (int speedDown){
		this.speed += speedDown;
		System.out.println("Audi slows down fast, current speed - " + this.speed);
		return speed;
	}
	
}

public class CarPolymorphism {
	

	public static void main (String args[])
	{
		Car myCar = new Car("BaseCar", 4);
		myCar.startEngine();
		myCar.Accelerate(100);
		myCar.slowDown(80);
		System.out.println("Done with base car");
		Porsche myPorsche = new Porsche();
		myPorsche.startEngine();
		myPorsche.Accelerate(100);
		myPorsche.slowDown(80);
		System.out.println("Done with Porsche");
		Mercedes myMercedes = new Mercedes();
		myPorsche.startEngine();
		myMercedes.Accelerate(80);
		myMercedes.slowDown(60);
		System.out.println("Done with Mercedes");
		Audi myAudi = new Audi();
		myPorsche.startEngine();
		myAudi.Accelerate(70);
		myAudi.slowDown(50);
		System.out.println("Done with Audi");
		
	
}
}
