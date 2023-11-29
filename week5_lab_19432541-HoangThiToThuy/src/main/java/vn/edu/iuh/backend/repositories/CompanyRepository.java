package vn.edu.iuh.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.backend.models.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
