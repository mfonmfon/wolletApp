package africa.semicolon.Wollet.services;

import africa.semicolon.Wollet.dtos.request.DepositRequest;
import africa.semicolon.Wollet.dtos.response.DepositResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WolletCustomerServiceImpl implements WolletCustomerService {

    @Autowired
    private WolletService wolletService;
    @Override
    public DepositResponse deposit(DepositRequest walletDepositRequest) {

        return null;
    }
}
