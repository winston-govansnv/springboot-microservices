package net.winstoncompany.organizationservice.service.impl;

import lombok.AllArgsConstructor;
import net.winstoncompany.organizationservice.dto.OrganizationDto;
import net.winstoncompany.organizationservice.entity.Organization;
import net.winstoncompany.organizationservice.mapper.OrganizationMapper;
import net.winstoncompany.organizationservice.repository.OrganizationRepository;
import net.winstoncompany.organizationservice.service.OrganizationService;
import org.springframework.stereotype.Service;

/**
 * @author winst
 * @Date 5/3/2023
 */

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        // convert OrganizationDto into Organization jpa entity
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);
        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}