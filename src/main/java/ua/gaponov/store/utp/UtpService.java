package ua.gaponov.store.utp;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ua.gaponov.store.user.User;
import ua.gaponov.store.user.UserService;
import ua.gaponov.store.utils.JsonConverter;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

/**
 * @author Andriy Gaponov
 */
@RequiredArgsConstructor
@Service
public class UtpService {

    private final UserService userService;
    @Value("${utp.url}")
    private String utpHttpServerUrl;
    @Value("${utp.user.name}")
    private String userName;
    @Value("${utp.user.password}")
    private String userPassword;

    public List<OrderRequestDto> getOrdersList() {

        User currentUser = userService.getCurrentUser();

        try {
            String url = utpHttpServerUrl + "?userName=" + currentUser.getUserName();
            String login = userName + ":" + userPassword;
            String base64login = Base64.getEncoder().encodeToString(login.getBytes());

            String response = Jsoup.connect(url)
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
