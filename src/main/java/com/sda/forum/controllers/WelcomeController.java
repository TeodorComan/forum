package com.sda.forum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@Controller("/")
public class WelcomeController {

    @RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
    // for query param
    public String greeting0(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("message", name);
        return "welcome";
    }


    @GetMapping("/hello")
    // for query param
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("message", name);
        return "welcome";
    }

    @GetMapping("/hello/{name}")
    public String greeting2(@PathVariable("name") String name, Model model) {
        model.addAttribute("message", name);
        return "welcome";
    }

    @GetMapping("/hi/{name:[\\d]+}")
    public String greeting3(@PathVariable("name") String name, Model model) {
        model.addAttribute("message", name);
        return "welcome";
    }


    @GetMapping({"/hi/{name}","/whatsup/{name}"})
    //ambiguous with previous
    public String greeting4(@PathVariable("name") String name, Model model) {
        model.addAttribute("message", name+"34");
        return "welcome";
    }

}
