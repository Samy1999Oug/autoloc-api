package fr.ece.autoloc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contractId;

    @Column(nullable = false, length = 20)
    private String signatureDate;

    @Column(nullable = false)
    private int totalAmount;

    @Column(nullable = false)
    private boolean valid;

    @OneToMany(mappedBy = "contract", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Payment> payments = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    private Reservation contract_reservation;

}
