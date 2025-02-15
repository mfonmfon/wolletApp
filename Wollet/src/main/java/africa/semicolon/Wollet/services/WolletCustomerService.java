package africa.semicolon.Wollet.services;

import africa.semicolon.Wollet.dtos.request.DepositRequest;
import africa.semicolon.Wollet.dtos.response.DepositResponse;
import africa.semicolon.Wollet.exception.UserNotFoundException;

public interface WolletCustomerService {
    DepositResponse deposit(DepositRequest walletDepositRequest) throws UserNotFoundException;

}
