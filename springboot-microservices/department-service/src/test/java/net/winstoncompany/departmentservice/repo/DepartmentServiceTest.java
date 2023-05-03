package net.winstoncompany.departmentservice.repo;

import net.winstoncompany.departmentservice.dto.DepartmentDto;
import net.winstoncompany.departmentservice.entity.Department;
import net.winstoncompany.departmentservice.repository.DepartmentRepository;
import net.winstoncompany.departmentservice.service.impl.DepartmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Winston Evans
 * @date 4/30/2023 11:22 AM
 */

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentServiceImpl departmentServiceImpl;

    @Test
    public void testFindDepartmentByCode() {
        when(departmentRepository.findByDepartmentCode(any(String.class))).thenReturn(new Department(1L, "HR", "HR Department", "HR001"));
        DepartmentDto result = departmentServiceImpl.getDepartmentByCode("HR001");
        assertThat(result.getDepartmentName()).isEqualTo("HR");
    }

    @Test
    public void testAddDepartment() {
        when(departmentRepository.save(any(Department.class))).thenReturn(new Department(1L, "HR", "HR Department", "HR001"));
        DepartmentDto result = departmentServiceImpl.saveDepartment(new DepartmentDto(1L, "HR", "HR Department", "HR001"));
        assertThat(result.getDepartmentName()).isEqualTo("HR");
    }
}