package africa.semicolon.Wollet.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    private Long id;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Wallet wallet;
}

