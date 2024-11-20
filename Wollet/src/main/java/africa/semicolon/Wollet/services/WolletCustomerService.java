package africa.semicolon.Wollet.services;

import africa.semicolon.Wollet.dtos.request.DepositRequest;
import africa.semicolon.Wollet.dtos.response.DepositResponse;

public interface WolletCustomerService {
    DepositResponse deposit(DepositRequest walletDepositRequest);

}
