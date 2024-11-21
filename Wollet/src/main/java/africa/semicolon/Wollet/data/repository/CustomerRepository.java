package africa.semicolon.Wollet.data.repository;

import africa.semicolon.Wollet.data.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
