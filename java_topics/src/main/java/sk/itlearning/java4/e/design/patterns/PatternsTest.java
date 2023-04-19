package sk.itlearning.java4.e.design.patterns;

import java.util.ArrayList;
import java.util.List;

import sk.itlearning.java4.e.pattern.factory.Vehicle;
import sk.itlearning.java4.e.pattern.factory.VehicleFactory;
import sk.itlearning.java4.e.pattern.factory.Vehicles;
import sk.itlearning.java4.e.pattern.mvc.Student;
import sk.itlearning.java4.e.pattern.mvc.StudentController;
import sk.itlearning.java4.e.pattern.mvc.StudentView;
import sk.itlearning.java4.e.pattern.singleton.Singleton;

/**
 *
 * Design patterns represent the best practices used by experienced
 * object-oriented software developers.
 *
 * Design patterns are solutions to general problems that software developers
 * faced during software development.
 *
 * These solutions were obtained by trial and error by numerous software
 * developers over quite a substantial period of time.
 *
 *
 * <table class="src">
 * <tbody>
 * <tr>
 * <td>1</td>
 * <td><b>Creational Patterns</b><br>
 * These design patterns provides way to create objects while hiding the
 * creation logic, rather than instantiating objects directly using new
 * operator. This gives program more flexibility in deciding which objects need
 * to be created for a given use case.</td>
 * </tr>
 * <tr>
 * <td>2</td>
 * <td><b>Structural Patterns</b><br>
 * These design patterns concern class and object composition. Concept of
 * inheritance is used to compose interfaces and define ways to compose objects
 * to obtain new functionalities.</td>
 * </tr>
 * <tr>
 * <td>3</td>
 * <td><b>Behavioral Patterns</b><br>
 * These design patterns are specifically concerned with communication between
 * objects.</td>
 * </tr>
 * <tr>
 * <td>4</td>
 * <td><b>J2EE Patterns</b><br>
 * These design patterns are specifically concerned with the presentation tier.
 * These patterns are identified by Sun Java Center.</td>
 * </tr>
 * </tbody>
 * </table>
 */
public class PatternsTest {

	public static void main(String[] args) {

		// Singleton
		Singleton singleObject = Singleton.getInstance();
		singleObject.showMessage();

		// Factory
		VehicleFactory factory = new VehicleFactory();

		List<Vehicle> vehicleList = new ArrayList<>();

		vehicleList.add(factory.createVehicle(Vehicles.Bentley));
		vehicleList.add(factory.createVehicle(Vehicles.Dacia));

		vehicleList.forEach(v -> v.draw());

		/* 
		 * MVC (Model View Controller)
		 * 
		 * Model represents an object or JAVA POJO carrying data. 
		 * It can also have logic to update controller if its data changes.
		 * 
		 * View represents the visualization of the data that model contains.
		 * 
		 * Controller acts on both model and view. 
		 * It controls the data flow into model object and updates the view whenever data changes. 
		 * It keeps view and model separate.
		 */
		Student model = retriveStudentFromDatabase();
		StudentView view = new StudentView();
		StudentController controller = new StudentController(model, view);
		controller.updateView();
		controller.setStudentName("John");
		controller.updateView();
	}

	private static Student retriveStudentFromDatabase() {
		Student student = new Student();
		student.setName("Robert");
		student.setRollNo("10");
		return student;
	}
}