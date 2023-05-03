package net.winstoncompany.departmentservice.service.impl;/**
 * @author winst
 * @Date 4/30/2023
 */

import lombok.AllArgsConstructor;
import net.winstoncompany.departmentservice.dto.DepartmentDto;
import net.winstoncompany.departmentservice.entity.Department;
import net.winstoncompany.departmentservice.mapper.DepartmentMapper;
import net.winstoncompany.departmentservice.repository.DepartmentRepository;
import net.winstoncompany.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

/**
 *
 *@author Winston Evans
 *@date 4/30/2023 9:09 AM
 */
@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        // convert department dto to department jpb entity
        Department department= DepartmentMapper.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        // Convert department to department dto
        DepartmentDto savedDepartmentDto =DepartmentMapper.mapToDepartmentDto(department);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);
        return departmentDto;
    }
}