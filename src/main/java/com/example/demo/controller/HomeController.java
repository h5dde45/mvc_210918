package com.example.demo.controller;

import org.springframework.ui.Model;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

//@Controller
public class HomeController {

//    @GetMapping("/")
    public String home(Locale locale, Model model) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String format = dateFormat.format(date);
        model.addAttribute("serverTime", format);

        return "home";
    }


}
