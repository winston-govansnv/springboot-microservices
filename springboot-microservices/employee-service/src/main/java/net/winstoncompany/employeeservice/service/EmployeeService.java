package net.winstoncompany.employeeservice.service;

import net.winstoncompany.employeeservice.dto.APIResponseDto;
import net.winstoncompany.employeeservice.dto.EmployeeDto;
import net.winstoncompany.employeeservice.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

/**
 * @author winst
 * @Date 4/30/2023
 */


public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long employeeId);
}
