package ua.gaponov.store.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Andriy Gaponov
 */
@RequestMapping("/orders")
@RequiredArgsConstructor
@Controller
public class StoreController {

    @GetMapping("/list")
    public ModelAndView getMainPage() {
        ModelAndView result = new ModelAndView("orders/list");
        return result;
    }
}
