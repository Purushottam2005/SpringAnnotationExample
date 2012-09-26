package emptest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	public String hire(String name) {
		String message = employeeDao.getMessage("Hire");
		return name + ", " + message;
	}

	public String fire(String name) {
		String message = employeeDao.getMessage("Fire");
		return name + ", " + message;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
}
