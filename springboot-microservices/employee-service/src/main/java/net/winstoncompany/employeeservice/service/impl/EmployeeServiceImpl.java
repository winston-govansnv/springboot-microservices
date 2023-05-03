package net.winstoncompany.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.winstoncompany.employeeservice.dto.APIResponseDto;
import net.winstoncompany.employeeservice.dto.DepartmentDto;
import net.winstoncompany.employeeservice.dto.EmployeeDto;
import net.winstoncompany.employeeservice.dto.OrganizationDto;
import net.winstoncompany.employeeservice.entity.Employee;
import net.winstoncompany.employeeservice.mapper.EmployeeMapper;
import net.winstoncompany.employeeservice.repository.EmployeeRepository;
import net.winstoncompany.employeeservice.service.APIClient;
import net.winstoncompany.employeeservice.service.APIOrganizationClient;
import net.winstoncompany.employeeservice.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author winst
 * @Date 4/30/2023
 */

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    // private RestTemplate restTemplate;
    private APIClient apiClient;
    private APIOrganizationClient apiOrganizationClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee saveEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        return savedEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).get();
//        ResponseEntity<DepartmentDto> responseEntity =  restTemplate.getForEntity("http://localhost:8080/api/departments/"+ employee.getDepartmentCode(),
//                DepartmentDto.class);

//        DepartmentDto departmentDto = responseEntity.getBody();

        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
        OrganizationDto organizationDto = apiOrganizationClient.getOrganization(employee.getOrganizationCode());

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setOrganizationDto(organizationDto);

        return apiResponseDto;
    }
}