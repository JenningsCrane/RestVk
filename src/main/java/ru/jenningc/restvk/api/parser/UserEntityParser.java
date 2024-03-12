package ru.jenningc.restvk.api.parser;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import ru.jenningc.restvk.store.entities.user.AddressEntity;
import ru.jenningc.restvk.store.entities.user.CompanyEntity;
import ru.jenningc.restvk.store.entities.user.GeoEntity;
import ru.jenningc.restvk.store.entities.user.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Slf4j
public class UserEntityParser {
    public static <T> List<T> parseJSONArray(JSONArray jsonArray, Function<JSONObject, T> parser) {
        List<T> entities = new ArrayList<>();

        try {
            for (Object o : jsonArray) {
                JSONObject jsonObject = (JSONObject) o;
                T entity = parser.apply(jsonObject);
                entities.add(entity);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return entities;
    }

    public static UserEntity parseUserJSONObject(JSONObject jsonObject) {
        return UserEntity.builder()
                .id((Long) jsonObject.get("id"))
                .name((String) jsonObject.get("name"))
                .userName((String) jsonObject.get("username"))
                .email((String) jsonObject.get("email"))
                .address(parseAddressJSONObject((JSONObject) jsonObject.get("address")))
                .phone((String) jsonObject.get("phone"))
                .website((String) jsonObject.get("website"))
                .company(parseCompanyJSONObject((JSONObject) jsonObject.get("company")))
                .build();
    }

    private static AddressEntity parseAddressJSONObject(JSONObject addressObject) {
        return AddressEntity.builder()
                .street((String) addressObject.get("street"))
                .suite((String) addressObject.get("suite"))
                .city((String) addressObject.get("city"))
                .zipcode((String) addressObject.get("zipcode"))
                .geoPosition(parseGeoJSONObject((JSONObject) addressObject.get("geo")))
                .build();
    }

    private static GeoEntity parseGeoJSONObject(JSONObject geoObject) {
        return GeoEntity.builder()
                .lat(Double.parseDouble((String) geoObject.get("lat")))
                .lng(Double.parseDouble((String) geoObject.get("lng")))
                .build();
    }

    private static CompanyEntity parseCompanyJSONObject(JSONObject companyObject) {
        return CompanyEntity.builder()
                .name((String) companyObject.get("name"))
                .catchPhrase((String) companyObject.get("catchPhrase"))
                .bs((String) companyObject.get("bs"))
                .build();
    }
}
