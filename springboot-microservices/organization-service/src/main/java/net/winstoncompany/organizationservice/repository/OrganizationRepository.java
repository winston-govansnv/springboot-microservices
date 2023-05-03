package net.winstoncompany.organizationservice.repository;

import net.winstoncompany.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author winst
 * @Date 5/3/2023
 */
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Organization findByOrganizationCode(String organizationCode);
}
