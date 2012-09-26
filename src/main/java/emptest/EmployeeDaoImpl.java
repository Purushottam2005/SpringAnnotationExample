package emptest;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private SimpleJdbcTemplate jdbcTemplate;

	@PostConstruct
	public void initialize() {
		
		jdbcTemplate.update("create table messages (messagekey varchar(20), message varchar(100))");
		jdbcTemplate.update("insert into messages (messagekey, message) values ('Hire', 'Congrats! You are hired')");
		jdbcTemplate.update("insert into messages (messagekey, message) values ('Fire', 'Sorry! You are fired')");
		
	}

	@PreDestroy
	public void remove() {
		jdbcTemplate.update("drop table messages");
	}

	public String getMessage(String messageKey) {
		
		return jdbcTemplate.queryForObject(
				"select message from messages where messagekey = ?",
				String.class, messageKey);
		
	}

//	 @Resource(name = "dmdataSource")
//	 public void createTemplate(DataSource dataSource) {
//	 this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
//	 }

	@Autowired
	public void createTemplate(DataSource dataSource) {
		this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}

		
//	 @Autowired
//	 public void createTemplate(@Qualifier("dmdataSource")
//	 DataSource dataSource) {
//	 this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
//	 }
}
