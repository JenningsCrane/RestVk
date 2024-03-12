package ru.jenningc.restvk.store.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.jenningc.restvk.store.entities.user.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
}
