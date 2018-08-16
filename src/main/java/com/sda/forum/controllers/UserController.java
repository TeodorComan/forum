package com.sda.forum.controllers;


import com.sda.forum.model.UserModel;
import com.sda.forum.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("user/create", "user", new UserModel());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createUser(@Valid @ModelAttribute("user")UserModel userModel,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {

            model.addAttribute("timestamp",new Date());
            model.addAttribute("error","Model Validation Error");
            model.addAttribute("status","Failed Validation");
            model.addAttribute("message",result.getAllErrors().get(0).getDefaultMessage());
            return "error";
        }

        userService.createUser(userModel.toUser());

        model.addAttribute("user", userModel);

        return "user/view";
    }

}
