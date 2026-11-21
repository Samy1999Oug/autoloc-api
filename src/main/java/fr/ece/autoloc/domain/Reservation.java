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
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reservationId;

    @Column(nullable = false, length = 20)
    private String startDate;

    @Column(nullable = false, length = 20)
    private String endDate;

    @Column(nullable = false, length = 20)
    private  String status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer_reservation;

    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicle reservation_vehicle;

    @OneToOne(mappedBy = "contract_reservation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Contract contract;
}
