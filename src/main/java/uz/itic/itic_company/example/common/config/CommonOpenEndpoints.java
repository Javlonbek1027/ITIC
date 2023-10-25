package uz.itic.itic_company.example.common.config;

import org.springframework.http.HttpMethod;
import org.springframework.util.AntPathMatcher;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.List.of;

public interface CommonOpenEndpoints {

    List<String> swaggerPaths = List.of("/swagger-ui/**",
            "/v3/api-docs/**",
            "/configuration/ui",
            "/swagger-resources",
            "/configuration/security",
            "/swagger-ui.html"
    );

    String SWAGGER_AUTH = "/swagger-auth";
    String COMMON_API = "/api/public/**";
    String COMMON_API_FOR_FILE = "/api/file/**";

    Map<HttpMethod, List<String>> OPEN_ENDPOINTS = Map.of(
            HttpMethod.POST, of(COMMON_API,
                    COMMON_API_FOR_FILE
            ),
            HttpMethod.DELETE, of(),
            HttpMethod.GET, of(COMMON_API,
                    COMMON_API_FOR_FILE,
                    SWAGGER_AUTH),
            HttpMethod.PUT, of()
    );
    default List<String> getByMethod(HttpMethod method) {
        var endpoints = OPEN_ENDPOINTS.get(method);
        return Objects.nonNull(endpoints) ? endpoints : Collections.emptyList();
    }

    default String[] getByMethodArr(HttpMethod method) {
        return getByMethod(method).toArray(new String[]{});
    }

    default String[] getPostOpenEndpoints() {
        return getByMethodArr(HttpMethod.POST);
    }

    default String[] getGetOpenEndpoints() {
        return getByMethodArr(HttpMethod.GET);
    }

    default boolean isRequestForSwagger(String servletPath) {
        return swaggerPaths.stream().anyMatch(pattern -> new AntPathMatcher().match(pattern, servletPath));
    }

}
