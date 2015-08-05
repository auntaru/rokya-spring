package com.blogpost.maven.maven_spring;

public class MaintainVehicle {
	public void washVehicle(Vehicle vehicle) {
		System.out.printf("%s is now being washed...\n", vehicle.getType());
		vehicle.setWashed(true);
	}

	public void serviceVehicle(Vehicle vehicle) {
		System.out.printf("%s is now being serviced...\n", vehicle.getType());
		vehicle.setServiced(true);
	}
}