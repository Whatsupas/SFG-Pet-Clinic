package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/owners")
@Controller
public class OwnersController {
    @RequestMapping(value = {"","/","/index","/index.html"})
    public String listOwners(){
        return "/owners/index";
    }
}
