package fr.ece.autoloc.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentId;

    @Column(nullable = false, length = 20)
    private String amount;

    @Column(nullable = false, length = 20)
    private String paymentDate;


    @Column(nullable = false, length = 20)
    private String paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    private Contract contract;
}
