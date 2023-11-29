package vn.edu.iuh.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.backend.models.Address;

public interface AddressRepository extends JpaRepository<Address,Long> {

}
