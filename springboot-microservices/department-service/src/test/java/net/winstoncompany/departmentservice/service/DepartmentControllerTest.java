package net.winstoncompany.departmentservice.service;

import net.winstoncompany.departmentservice.controller.DepartmentController;
import net.winstoncompany.departmentservice.dto.DepartmentDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 *
 *@author Winston Evans
 *@date 4/30/2023 10:51 AM
 */
@ExtendWith(MockitoExtension.class)
public class DepartmentControllerTest {

    @InjectMocks
    DepartmentController departmentController;

    @Mock
    DepartmentService departmentService;


    @Test
    public void testAddEmployee()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(departmentService.saveDepartment(any(DepartmentDto.class))).thenReturn(new DepartmentDto(1L,"HR","HR Department", "HR001"));
        DepartmentDto employeeToAdd = new DepartmentDto(1L, "HR", "HR department", "HR001");
        ResponseEntity<DepartmentDto> responseEntity = departmentController.saveDepartment(employeeToAdd);
        assertThat(responseEntity.getStatusCode().is2xxSuccessful());
    }


    @Test
    public void testFindByDepartmentCode() {
        DepartmentDto department1 = new DepartmentDto(1L, "HR", "HR Department", "HR001");
        when(departmentService.getDepartmentByCode(any(String.class))).thenReturn(new DepartmentDto(1L, "HR", "HR Department", "HR001"));
        DepartmentDto result = departmentController.getDepartment("HR001").getBody();
        assertThat(result.getDepartmentName()).isEqualTo("HR");
    }
}