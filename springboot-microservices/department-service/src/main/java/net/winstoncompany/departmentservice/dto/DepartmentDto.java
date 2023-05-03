package net.winstoncompany.departmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 *
 *@author Winston Evans
 *@date 4/30/2023 9:05 AM
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
 private Long id;
 private String departmentName;
 private String departmentDescription;
 private String departmentCode;
}