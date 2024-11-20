package africa.semicolon.Wollet.dtos;

import africa.semicolon.Wollet.dtos.request.DepositRequest;
import africa.semicolon.Wollet.dtos.response.DepositResponse;
import africa.semicolon.Wollet.services.WolletCustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private WolletCustomerService customerService;

    @Test
    public void testThatCustomerCanDeposit(){
        Long walletId = 1L;
        BigDecimal depositAmount = new BigDecimal("5000.00");
        String description = "This is just a test";
        DepositRequest walletDepositRequest = new DepositRequest();
        walletDepositRequest.setDescription(description);
        walletDepositRequest.setAmount(depositAmount);
        walletDepositRequest.setWalletId(walletId);
        DepositResponse depositResponse =  customerService.deposit(walletDepositRequest);
        assertEquals("Deposit successfully",depositResponse.getMessage());

        // Assert that the deposit was successful and the wallet balance was updated accordingly.



    }
}
