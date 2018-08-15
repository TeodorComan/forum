package com.sda.forum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("/")
public class WelcomeController {


    @GetMapping("/hello")
    // for query param
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("message", name);
        return "welcome.html";
    }

    @GetMapping("/hello/{name}")
    public String greeting2(@PathVariable("name") String name, Model model) {
        model.addAttribute("message", name);
        return "welcome.html";
    }

    @GetMapping("/hi/{name:[\\d]+}")
    public String greeting3(@PathVariable("name") String name, Model model) {
        model.addAttribute("message", name);
        return "welcome.html";
    }


    @GetMapping({"/hi/{name}","/whatsup/{name}"})
    //ambiguous with previous
    public String greeting4(@PathVariable("name") String name, Model model) {
        model.addAttribute("message", name+"34");
        return "welcome.html";
    }

}
