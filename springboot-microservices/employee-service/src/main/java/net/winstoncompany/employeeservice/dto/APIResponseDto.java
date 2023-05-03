package net.winstoncompany.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.winstoncompany.employeeservice.entity.Employee;

/**
 * @author winst
 * @Date 5/1/2023
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    private EmployeeDto employee;
    private DepartmentDto department;
    private OrganizationDto organizationDto;
}