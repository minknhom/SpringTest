package duongam.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/" )
public class HomeController {
    @GetMapping
    public String home() {
        System.out.println("Test");
        return "redirect:/customer/list";
    }
}
