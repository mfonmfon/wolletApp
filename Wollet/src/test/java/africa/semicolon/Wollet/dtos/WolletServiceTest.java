package africa.semicolon.Wollet.dtos;

import africa.semicolon.Wollet.dtos.request.WalletDepositRequest;
import africa.semicolon.Wollet.dtos.response.WalletDepositResponse;
import africa.semicolon.Wollet.exception.WalletNotFoundException;
import africa.semicolon.Wollet.services.WolletService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class WolletServiceTest {

    @Autowired
    private WolletService wolletService;

    @Test
    @Sql(scripts = {"/db/data.sql"})
    public void testCanDepositIntoWallet() throws WalletNotFoundException {
        Long id = 200L;
        BigDecimal walletAmount = new BigDecimal("300");
        WalletDepositRequest walletDepositRequest = new WalletDepositRequest();
        walletDepositRequest.setWalletId(id);
        walletDepositRequest.setAmount(walletAmount);
        WalletDepositResponse walletDepositResponse = wolletService.deposit(walletDepositRequest);
        assertNotNull(walletDepositResponse.getMessage());
    }
}
