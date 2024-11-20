package africa.semicolon.Wollet.services;

import africa.semicolon.Wollet.dtos.request.WalletDepositRequest;
import africa.semicolon.Wollet.dtos.response.WalletDepositResponse;

public interface WolletService {
    WalletDepositResponse deposit(WalletDepositRequest walletDepositRequest );
}
