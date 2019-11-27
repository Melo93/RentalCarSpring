package com.si2001.rentalcarspring.controller;


import com.si2001.rentalcarspring.entities.dto.LoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/")
public class IndexController {


    @RequestMapping()
    public String getWelcome(Model model, HttpServletRequest req) {
        model.addAttribute("intestazione", "Rental Car SI");
        req.getSession().setAttribute("intestazione", "Rental Car SI");
        model.addAttribute("loginDTO", new LoginDTO());
        return "index";
    }

}
