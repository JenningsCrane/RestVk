package ru.jenningc.restvk.store.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.jenningc.restvk.store.entities.user.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
