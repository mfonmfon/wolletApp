package africa.semicolon.Wollet.services;

import africa.semicolon.Wollet.data.model.Customer;
import africa.semicolon.Wollet.data.model.Wallet;
import africa.semicolon.Wollet.data.repository.CustomerRepository;
import africa.semicolon.Wollet.dtos.request.DepositRequest;
import africa.semicolon.Wollet.dtos.request.WalletDepositRequest;
import africa.semicolon.Wollet.dtos.response.DepositResponse;
import africa.semicolon.Wollet.dtos.response.WalletDepositResponse;
import africa.semicolon.Wollet.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WolletCustomerServiceImpl implements WolletCustomerService {


    private final WolletService wolletService;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    @Override
    public DepositResponse deposit(DepositRequest walletDepositRequest) throws UserNotFoundException {
        //1. find the customer
        Customer customer = customerRepository.findById(walletDepositRequest.getCustomerId())
                .orElseThrow(()-> new UserNotFoundException(
                        String.format(
                                "User not found with id %d", walletDepositRequest.getCustomerId()
                        )));
        //2. get the customer wallet

        Wallet wallet  = customer.getWallet();
        WalletDepositRequest depositRequest = new WalletDepositRequest();
        depositRequest.setWalletId(wallet.getId());
        depositRequest.setAmount(walletDepositRequest.getAmount());
        //3. call the wollet service to deposit the amount
        WalletDepositResponse depositResponse =  wolletService.deposit(depositRequest);
        //4. update the customer wallet balance
        return modelMapper.map(depositResponse, DepositResponse.class);
    }
}
