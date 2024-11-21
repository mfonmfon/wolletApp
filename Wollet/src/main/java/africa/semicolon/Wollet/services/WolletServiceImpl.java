package africa.semicolon.Wollet.services;

import africa.semicolon.Wollet.data.model.Wallet;
import africa.semicolon.Wollet.data.repository.WalletRepository;
import africa.semicolon.Wollet.dtos.request.WalletDepositRequest;
import africa.semicolon.Wollet.dtos.response.WalletDepositResponse;
import africa.semicolon.Wollet.exception.WalletNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WolletServiceImpl implements WolletService{

    private final ModelMapper modelMapper;
    private final WalletRepository walletRepository;
    @Override
    public WalletDepositResponse deposit(WalletDepositRequest walletDepositRequest) {

//        modelMapper.map(walletDepositRequest, Wallet.class);

        //find the wallet by the id if the wallet does not exist it will throw an exception
      Wallet wallet = walletRepository.findById(walletDepositRequest.getWalletId())
              .orElseThrow(()-> new WalletNotFoundException("Wallet not found"));
      BigDecimal walletCurrentBalance = wallet.getBalance();
      //add the amount to the wallet
      wallet.setBalance(walletCurrentBalance.add(walletDepositRequest.getAmount()));
      wallet.setBalance(walletCurrentBalance);
      //save the updated wallet to the database
      wallet = walletRepository.save(wallet);
      WalletDepositResponse walletDepositResponse = new WalletDepositResponse();
      walletDepositResponse.setMessage("Deposit successfully");
      walletDepositResponse.setAmount(walletDepositRequest.getAmount().toString());
        return walletDepositResponse;
    }
}
