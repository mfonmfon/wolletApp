package africa.semicolon.Wollet.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DepositRequest {
    private Long walletId;
    private BigDecimal amount;
    private String description;
}
