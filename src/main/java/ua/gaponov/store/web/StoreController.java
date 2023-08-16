package ua.gaponov.store.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.gaponov.store.utp.OrderRequestDto;
import ua.gaponov.store.utp.UtpService;

import java.util.List;

/**
 * @author Andriy Gaponov
 */
@RequestMapping("/orders")
@RequiredArgsConstructor
@Controller
public class StoreController {

    private final UtpService utpService;

    @GetMapping("/list")
    public ModelAndView getMainPage() {
        ModelAndView result = new ModelAndView("orders/list");
        List<OrderRequestDto> ordersList = utpService.getOrdersList();
        result.addObject("ordersList", ordersList);
        result.addObject("reloadTime", 180);
        return result;
    }
}
