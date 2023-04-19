package sk.itlearning.java4.e.pattern.factory;

public class VehicleFactory {

	public Vehicle createVehicle(Vehicles vehicle) {

		switch (vehicle) {
		case Bentley:
			return new Bentley();
		case Dacia:
			return new Dacia();
		default:
			return null;
		}
	}

}
