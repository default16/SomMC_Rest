package com.rasulberov.my_rest_service.dao;

import com.rasulberov.my_rest_service.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();
}
