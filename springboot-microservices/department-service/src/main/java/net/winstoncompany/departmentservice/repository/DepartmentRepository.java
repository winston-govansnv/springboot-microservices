package net.winstoncompany.departmentservice.repository;

import net.winstoncompany.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author winst
 * @Date 4/30/2023
 */

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentCode(String departmentCode);
}
