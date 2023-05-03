package net.winstoncompany.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author winst
 * @Date 4/30/2023
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String LastName;
    private String email;
    private String departmentCode;
    private String organizationCode;
}