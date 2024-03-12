package ru.jenningc.restvk.store.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.jenningc.restvk.store.entities.user.UserEntity;

import java.util.stream.Stream;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Stream<UserEntity> streamAllBy();


}
