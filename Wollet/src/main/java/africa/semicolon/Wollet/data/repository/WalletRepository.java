package africa.semicolon.Wollet.data.repository;

import africa.semicolon.Wollet.data.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository  extends JpaRepository<Wallet, Long> {
}
