package net.winstoncompany.departmentservice.service;

import net.winstoncompany.departmentservice.dto.DepartmentDto;

/**
 * @author winst
 * @Date 4/30/2023
 */
public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);
}
