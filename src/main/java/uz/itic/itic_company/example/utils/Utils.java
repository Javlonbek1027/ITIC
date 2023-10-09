package uz.itic.itic_company.example.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import uz.itic.itic_company.example.component.Localization;
import uz.itic.itic_company.example.model.dto.Header;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Utils {


    public static void writerErrorResp(Exception exception, HttpServletResponse response, int status, String errorCode, ObjectMapper objectMapper) throws IOException {
        PrintWriter writer = response.getWriter();
        Header<String> customResponse = Header.error(errorCode, BeanUtils.getBean(Localization.class).getMessage(exception.getMessage()));
        response.setStatus(status);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        final var content = objectMapper.writeValueAsString(customResponse);
        writer.println(content);
    }

    public static void writerErrorResp(String message, HttpServletResponse response, int status, String errorCode, ObjectMapper objectMapper) throws IOException {
        PrintWriter writer = response.getWriter();
        Header<String> customResponse = Header.error(errorCode, message);
        response.setStatus(status);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        final var content = objectMapper.writeValueAsString(customResponse);
        writer.println(content);
    }

    @SafeVarargs
    public static <T> T coalesce(T... arr) {
        for (T number : arr) {
            if (Objects.nonNull(number))
                return number;
        }
        return null;
    }

    public static String generateDownloadUrl(String fileServerName, String serverHost) {
        return String.format("%s/api/file/download/%s", serverHost, fileServerName);
    }


}
