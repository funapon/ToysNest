package tk.toysnest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/toysnest")
public class ToysNestController {
    @GetMapping
    public String index() {
        return "page/index";
    }
}
