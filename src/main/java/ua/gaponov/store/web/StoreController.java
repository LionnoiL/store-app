package ua.gaponov.store.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ua.gaponov.store.utp.OrderRequestDto;
import ua.gaponov.store.utp.UtpService;

import java.util.List;
import java.util.UUID;

/**
 * @author Andriy Gaponov
 */
@RequestMapping("/orders")
@RequiredArgsConstructor
@Controller
public class StoreController {

    private final UtpService utpService;

    @Value("${orders.list.reload.interval}")
    private int reloadPageInterval;

    @GetMapping("/list")
    public ModelAndView getMainPage() {
        ModelAndView result = new ModelAndView("orders/list");
        List<OrderRequestDto> ordersList = utpService.getOrdersList();
        result.addObject("ordersList", ordersList);
        result.addObject("reloadTime", reloadPageInterval);
        return result;
    }

    @GetMapping("/edit")
    public ModelAndView getEditOrder(@RequestParam(value = "id") String id) {
        ModelAndView result = new ModelAndView("orders/edit");
        OrderRequestDto order = utpService.getOrder(id);
        result.addObject("order", order);
        return result;
    }

    @PostMapping("/edit")
    public RedirectView postUpdateOrder(@ModelAttribute("order") OrderRequestDto order) {
        utpService.sendCompleteOrderToUtp(order);
        RedirectView redirect = new RedirectView();
        redirect.setUrl("/");
        return redirect;
    }
}
