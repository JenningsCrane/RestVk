package ru.jenningc.restvk.api.controllers;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.jenningc.restvk.api.client.ApiClient;
import ru.jenningc.restvk.api.dto.UserDto;
import ru.jenningc.restvk.api.factories.UserDtoFactory;
import ru.jenningc.restvk.api.parser.UserEntityParser;
import ru.jenningc.restvk.store.entities.user.UserEntity;
import ru.jenningc.restvk.store.repositories.user.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Transactional
@RestController
public class UserController {

    private final UserRepository userRepository;

    private final UserDtoFactory userDtoFactory;

    public static final String URL_USERS = "https://jsonplaceholder.typicode.com/users";

    public static final String GET_USERS = "/api/users";

    @GetMapping(GET_USERS)
    public List<UserDto> userDtoList() {
        try {

            JSONArray usersJsonArray = ApiClient.getJsonData(URL_USERS);

            List<UserEntity> userEntities = UserEntityParser.parseJSONArray(usersJsonArray, UserEntityParser::parseUserJSONObject);

            return userEntities.stream()
                    .map(userDtoFactory::makeUserDto)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            log.error(e.getMessage());
        }


        return null;
    }
}
