package eccomerce.tp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {

    @GetMapping("/web/index")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/web/cart/{cartId}")
    public String cart(Model model, @PathVariable int cartId) {
        model.addAttribute("cartId", cartId);
        return "cart";
    }


}
