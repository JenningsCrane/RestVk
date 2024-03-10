package ru.jenningc.restvk.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import ru.jenningc.restvk.store.entities.user.AddressEntity;
import ru.jenningc.restvk.store.entities.user.CompanyEntity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NonNull
    private Long id;

    @NonNull
    private String name;

    @NonNull
    @JsonProperty("username")
    private String userName;

    @NonNull
    private String email;

    @NonNull
    private AddressEntity address;

    @NonNull
    private String phone;

    @NonNull
    private String website;

    @NonNull
    private CompanyEntity company;

}
