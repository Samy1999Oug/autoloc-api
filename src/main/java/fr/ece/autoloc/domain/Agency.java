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
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long agencyId;

    @Column(nullable = false, unique = true, length = 20)
    private String name;

    @Column(nullable = false, length = 20)
    private String city;

    @Column(nullable = false, unique = true, length = 20)
    private String address;

    @Column(nullable = false, unique = true, length = 20)
    private String phone;

    @OneToMany(mappedBy="agency_vehicle", fetch = FetchType.LAZY)
    private List<Vehicle> vehicles = new ArrayList<>();

    @OneToMany(mappedBy="agency_employee", fetch = FetchType.LAZY)
    private List<Employee> employee = new ArrayList<>();

}
