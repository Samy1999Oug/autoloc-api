package fr.ece.autoloc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    @Column(nullable = false, unique = true, length = 20)
    private String registrationNumber;

    @Column(nullable = false, length = 50)
    private String brand;

    @Column(nullable = false, length = 50)
    private String model;

    @Column(nullable = false, length = 20)
    private String category;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal dailyRate;

    @Column(nullable = false, length = 20)
    private StatutVehicule status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Agency agency_vehicle;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "vehicle_equipment")
    private Set<Equipment> equipments = new HashSet<>();

    @OneToMany(mappedBy="reservation_vehicle",fetch = FetchType.LAZY)
    private List<Reservation> reservations = new ArrayList<>();

    @OneToMany(mappedBy="vehicle_maintenance", fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private List<Maintenance> maintenances = new ArrayList<>();

}
