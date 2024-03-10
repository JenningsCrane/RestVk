package ru.jenningc.restvk.store.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.jenningc.restvk.store.entities.user.GeoEntity;

public interface GeoRepository extends JpaRepository<GeoEntity, Long> {
}
