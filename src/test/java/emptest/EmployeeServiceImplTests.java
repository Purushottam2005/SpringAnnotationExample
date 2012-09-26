package emptest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class EmployeeServiceImplTests extends
		AbstractDependencyInjectionSpringContextTests {
	
	@Autowired
	private EmployeeService employeeService;

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "context.xml" };
	}

	public void testHire() {
		String name = "Tom";
		String message = employeeService.hire(name);
		assertEquals(name + ", " + "Congrats! You are hired", message);
	}

	public void testGermanWelcome() {
		String name = "Jim";
		String message = employeeService.fire(name);
		assertEquals(name + ", " + "Sorry! You are fired", message);
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
}
