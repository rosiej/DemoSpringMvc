package pl.rosiejka.demospringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("/")
    public String helloWorld(Model model){
        model.addAttribute("message","Witaj w kontrolerze!");
        return "resultPage";
    }
}
