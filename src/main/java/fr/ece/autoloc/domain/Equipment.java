package fr.ece.autoloc.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long equipmentId;

    @Column(nullable = false, length = 20)
    private String label;

    @ManyToMany(mappedBy = "equipments", fetch = FetchType.LAZY)
    private Set<Vehicle> vehicles = new HashSet<>();
}
