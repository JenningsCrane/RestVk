package ru.jenningc.restvk.api.factories;

import org.springframework.stereotype.Component;
import ru.jenningc.restvk.api.dto.UserDto;
import ru.jenningc.restvk.store.entities.user.AddressEntity;
import ru.jenningc.restvk.store.entities.user.CompanyEntity;
import ru.jenningc.restvk.store.entities.user.GeoEntity;
import ru.jenningc.restvk.store.entities.user.UserEntity;

@Component
public class UserDtoFactory {

    public UserDto makeUserDto(UserEntity user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .userName(user.getUserName())
                .email(user.getEmail())
                .address(user.getAddress())
                .phone(user.getPhone())
                .website(user.getWebsite())
                .company(user.getCompany())
                .build();
    }

}
