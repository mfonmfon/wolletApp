package africa.semicolon.Wollet.dtos;

import africa.semicolon.Wollet.dtos.request.DepositRequest;
import africa.semicolon.Wollet.dtos.response.DepositResponse;
import africa.semicolon.Wollet.exception.UserNotFoundException;
import africa.semicolon.Wollet.services.WolletCustomerService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CustomerServiceTest {

    private static final Logger log = LoggerFactory.getLogger(CustomerServiceTest.class);
    @Autowired
    private WolletCustomerService customerService;

    @Test
    @Sql(scripts = {"/db/data.sql"})
    public void testThatCustomerCanDeposit() throws UserNotFoundException {
        Long customerId = 100L;
        BigDecimal depositAmount = new BigDecimal("5000.00");
        String description = "This is just a test";
        DepositRequest walletDepositRequest = buildDepositRequest(description, depositAmount, customerId);
        DepositResponse depositResponse =  customerService.deposit(walletDepositRequest);
        log.info("response:: " + depositResponse);
        assertEquals("Deposit successfully",depositResponse.getMessage());
        // Assert that the deposit was successful and the wallet balance was updated accordingly.
    }

    private static DepositRequest buildDepositRequest(String description, BigDecimal depositAmount, Long walletId) {
        DepositRequest walletDepositRequest = new DepositRequest();
        walletDepositRequest.setDescription(description);
        walletDepositRequest.setAmount(depositAmount);
        walletDepositRequest.setCustomerId(walletId);
        return walletDepositRequest;
    }
}
