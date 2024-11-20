package africa.semicolon.Wollet.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class WalletDepositResponse {
    private String message;
    private String amount;
}
