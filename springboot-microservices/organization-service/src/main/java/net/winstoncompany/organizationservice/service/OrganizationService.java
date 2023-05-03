package net.winstoncompany.organizationservice.service;

import net.winstoncompany.organizationservice.dto.OrganizationDto;

/**
 * @author winst
 * @Date 5/3/2023
 */

public interface OrganizationService {
    OrganizationDto saveOrganization(OrganizationDto organizationDto);

    OrganizationDto getOrganizationByCode(String organizationCode);
}