package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.models.api.Product; /* TODO: Employee API? */
import edu.uark.models.entities.fieldnames.EmployeeFieldNames;
import edu.uark.models.repositories.EmployeeRepository;

public class EmployeeEntity extends BaseEntity<EmployeeEntity> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.firstName = rs.getString(EmployeeFieldNames.FIRST_NAME);
		this.lastName = rs.getString(EmployeeFieldNames.LAST_NAME);
		this.employeeID = rs.getInt(EmployeeFieldNames.EMPLOYEE_ID);
		this.active = rs.getBoolean(EmployeeFieldNames.ACTIVE);
		this.role = rs.getInt(EmployeeFieldNames.ROLE);
		this.manager = rs.getInt(EmployeeFieldNames.MANAGER);
		this.password = rs.getString(EmployeeFieldNames.PASSWORD);
		this.createdOn = rs.getTimestamp(EmployeeFieldNames.CREATED_ON).toLocalDateTime();
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(EmployeeFieldNames.FIRST_NAME, this.firstName);
		record.put(EmployeeFieldNames.LAST_NAME, this.lastName);
		record.put(EmployeeFieldNames.EMPLOYEE_ID, this.employeeID);
		record.put(EmployeeFieldNames.ACTIVE, this.active);
		record.put(EmployeeFieldNames.ROLE, this.role);
		record.put(EmployeeFieldNames.MANAGER, this.manager);
		record.put(EmployeeFieldNames.PASSWORD, this.password);
		record.put(EmployeeFieldNames.CREATED_ON, Timestamp.valueOf(this.createdOn));
		
		return record;
	}

	/* ID is handled by BaseEntity */
	
	private String firstName;
	public String getFirstName() {
		return this.firstName;
	}
	public EmployeeEntity setFirstName(String firstName) {
		if (!StringUtils.equals(this.firstName, firstName)) {
			this.firstName = firstName;
			this.propertyChanged(EmployeeFieldNames.FIRST_NAME);
		}
		
		return this;
	}
	
	private String lastName;
	public String getLastName() {
		return this.lastName;
	}
	public EmployeeEntity setLastName(String lastName) {
		if (!StringUtils.equals(this.lastName, lastName)) {
			this.lastName = lastName;
			this.propertyChanged(EmployeeFieldNames.LAST_NAME);
		}
		
		return this;
	}
	
	private int employeeID;
	public int getEmployeeID() {
		return this.employeeID;
	}
	public EmployeeEntity setEmployeeID(int employeeID) {
		if (this.employeeID != employeeID) {
			this.employeeID = employeeID;
			this.propertyChanged(EmployeeFieldNames.EMPLOYEE_ID);
		}
		
		return this;
	}
	
	private boolean active; 
	public boolean getActive() {
		return this.active;
	}
	public EmployeeEntity setActive(boolean active) {
		if (this.active != active) {
			this.active = active;
			this.propertyChanged(EmployeeFieldNames.ACTIVE);
		}
		
		return this;
	}
	
	private int role;
	public int getRole() {
		return this.role;
	}
	public EmployeeEntity setRole(int role) {
		if (this.role != role) {
			this.role = role;
			this.propertyChanged(EmployeeFieldNames.ROLE);
		}
		
		return this;
	}
	
	private int manager;
	public int getManager() {
		return this.manager;
	}
	public EmployeeEntity setManager(int manager) {
		if (this.manager != manager) {
			this.manager = manager;
			this.propertyChanged(EmployeeFieldNames.EMPLOYEE_ID);
		}
		
		return this;
	}
	
	private String password;
	public String getPassword() {
		return this.password;
	}
	public EmployeeEntity setPassword(String password) {
		if (!StringUtils.equals(this.password, password)) {
			this.password = password;
			this.propertyChanged(EmployeeFieldNames.PASSWORD);
		}
		
		return this;
	}
	
	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	
	public EmployeeEntity() {
		super(new EmployeeRepository());
		
		this.firstName = StringUtils.EMPTY;
		this.lastName = StringUtils.EMPTY;
		this.employeeID = -1;
		this.active = false;
		this.role = -1;
		this.manager = -1;
		this.password = StringUtils.EMPTY;
		this.createdOn = LocalDateTime.now();
	}
	
	public EmployeeEntity(UUID id) {
		super(id, new EmployeeRepository());
		
		this.firstName = StringUtils.EMPTY;
		this.lastName = StringUtils.EMPTY;
		this.employeeID = -1;
		this.active = false;
		this.role = -1;
		this.manager = -1;
		this.password = StringUtils.EMPTY;
		this.createdOn = LocalDateTime.now();
	}

}
