package ua.gaponov.store.utp;

import lombok.RequiredArgsConstructor;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ua.gaponov.store.errors.ErrorMessages;
import ua.gaponov.store.errors.UtpServerException;
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

    private String getBasicAuthString() {
        String login = userName + ":" + userPassword;
        return "Basic " + Base64.getEncoder().encodeToString(login.getBytes());
    }

    public List<OrderRequestDto> getOrdersList() {

        User currentUser = userService.getCurrentUser();

        try {
            String url = utpHttpServerUrl + "?userName=" + currentUser.getUserName();
            String response = Jsoup.connect(url)
                    .header("Authorization", getBasicAuthString())
                    .timeout(30000)
                    .ignoreContentType(true).get().body().text();
            List<OrderRequestDto> ordersList = JsonConverter.convertJsonStringToList(
                    response, OrderRequestDto.class);
            return ordersList;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public OrderRequestDto getOrder(String orderGuid) {
        User currentUser = userService.getCurrentUser();
        try {
            String url = utpHttpServerUrl + "?userName=" + currentUser.getUserName() + "&orderGuid=" + orderGuid;
            String response = Jsoup.connect(url)
                    .header("Authorization", getBasicAuthString())
                    .ignoreContentType(true).get().body().text();
            OrderRequestDto order = JsonConverter.GSON.fromJson(response, OrderRequestDto.class);
            return order;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendCompleteOrderToUtp(OrderRequestDto order) {
        OrderUtpReturnDto returnDto = OrderUtpReturnDto.builder()
                .docGuid(order.getDocGuid())
                .products(
                        order.getProducts().stream()
                                .map(p -> OrderItemUtpReturnDto.builder()
                                        .lineNumber(p.getLineNumber())
                                        .productGuid(p.getProductGuid())
                                        .productName(p.getProductName())
                                        .productCode(p.getProductCode())
                                        .productUnitName(p.getProductUnitName())
                                        .productQtyComplete(p.getProductQtyComplete())
                                        .build())
                                .toList()
                )
                .build();

        try {
            String url = utpHttpServerUrl;
            Connection.Response response = Jsoup.connect(url)
                    .header("Authorization", getBasicAuthString())
                    .timeout(30000)
                    .ignoreContentType(true)
                    .method(Connection.Method.POST)
                    .requestBody(JsonConverter.GSON.toJson(returnDto))
                    .execute();

            int statusCode = response.statusCode();

        } catch (IOException e) {
            ErrorMessages errorMessages = new ErrorMessages();
            errorMessages.clear();
            errorMessages.addError("UTP server error");
            throw new UtpServerException(errorMessages);
        }
    }


}
