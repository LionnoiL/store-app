package ua.gaponov.store.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.gaponov.store.utp.OrderItemRequestDto;
import ua.gaponov.store.utp.OrderRequestDto;
import ua.gaponov.store.utp.UtpService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Andriy Gaponov
 */
@RequestMapping("/report")
@RequiredArgsConstructor
@Controller
public class ReportsController {

    private final UtpService utpService;

    @GetMapping("/byOrders")
    public ModelAndView getReportByOrders() {
        ModelAndView result = new ModelAndView("reports/byOrders");
        List<OrderRequestDto> ordersList = utpService.getOrdersList();
        result.addObject("ordersList", ordersList);
        return result;
    }

    @GetMapping("/byProducts")
    public ModelAndView getReportByProducts() {
        ModelAndView result = new ModelAndView("reports/byProducts");
        List<OrderRequestDto> ordersList = utpService.getOrdersList();

        Map<String, OrderItemRequestDto> uniqueSummedItems = ordersList.stream()
                .flatMap(orderRequest -> orderRequest.getProducts().stream())
                .collect(Collectors.toMap(
                        item -> item.getProductGuid(),
                        Function.identity(),
                        (existing, replacement) -> {
                            existing.setProductQty(existing.getProductQty() + replacement.getProductQty());
                            return existing;
                        }
                ));

        List<OrderItemRequestDto> products = new ArrayList<>(uniqueSummedItems.values());

        result.addObject("products", products.stream().sorted(Comparator.comparing(OrderItemRequestDto::getProductName)));
        return result;
    }
}
