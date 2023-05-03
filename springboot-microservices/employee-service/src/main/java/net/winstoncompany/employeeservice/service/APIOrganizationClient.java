package net.winstoncompany.employeeservice.service;

import net.winstoncompany.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author winst
 * @Date 5/3/2023
 */

@FeignClient(name="ORGANIZATION-SERVICE")
public interface APIOrganizationClient {

    @GetMapping("api/organizations/{code}")
    OrganizationDto getOrganization(@PathVariable("code") String organizationCode);

}
