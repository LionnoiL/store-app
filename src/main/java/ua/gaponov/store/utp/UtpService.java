package ua.gaponov.store.utp;

import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ua.gaponov.store.utils.JsonConverter;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

/**
 * @author Andriy Gaponov
 */
@Service
public class UtpService {

    @Value("${utp.url}")
    private String utpHttpServerUrl;
    @Value("${utp.user.name}")
    private String userName;
    @Value("${utp.user.password}")
    private String userPassword;

    public List<OrderRequestDto> getOrdersList() {

        try {
            String login = userName + ":" + userPassword;
            String base64login = Base64.getEncoder().encodeToString(login.getBytes());

            String response = Jsoup.connect(utpHttpServerUrl)
                    .header("Authorization", "Basic " + base64login)
                    .ignoreContentType(true).get().body().text();
            List<OrderRequestDto> ordersList = JsonConverter.convertJsonStringToList(
                    response, OrderRequestDto.class);
            return ordersList;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
