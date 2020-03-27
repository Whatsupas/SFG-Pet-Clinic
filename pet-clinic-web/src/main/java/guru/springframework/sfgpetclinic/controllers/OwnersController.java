package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping(value = "/owners")
@Controller
public class OwnersController {

    private final OwnerService ownerService;

    public OwnersController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping(value = {"","/","/index","/index.html","/find"})
    public String listOwners(Model model){
        model.addAttribute("owners",ownerService.findAll());
        return "/owners/index";
    }
}
