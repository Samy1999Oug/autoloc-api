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
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maintenanceId;

    @Column(nullable = false, length = 20)
    private String startDate;

    @Column(nullable = false, length = 20)
    private String endDate;

    @Column(nullable = false, length = 20)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicle vehicle_maintenance;

}
