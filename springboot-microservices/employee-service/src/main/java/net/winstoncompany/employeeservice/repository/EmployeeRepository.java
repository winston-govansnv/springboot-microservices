package net.winstoncompany.employeeservice.repository;

import net.winstoncompany.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author winst
 * @Date 4/30/2023
 */

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}