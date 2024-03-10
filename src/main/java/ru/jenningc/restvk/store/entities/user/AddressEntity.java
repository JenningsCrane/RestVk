package ru.jenningc.restvk.store.entities.user;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String street;

    private String suite;

    private String city;

    private String zipcode;

    @OneToOne
    private GeoEntity geoPosition;

}
