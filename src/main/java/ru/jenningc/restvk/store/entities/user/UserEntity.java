package ru.jenningc.restvk.store.entities.user;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @Column(name = "username")
    private String userName;

    private String email;

    @OneToOne
    private AddressEntity address;

    private String phone;

    private String website;

    @OneToOne
    private CompanyEntity company;
}
