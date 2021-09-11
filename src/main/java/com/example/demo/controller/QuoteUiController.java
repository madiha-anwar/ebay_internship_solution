package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class QuoteUiController {
    @RequestMapping(value = "/getquote")
    public ModelAndView getUi() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("quotee");
        mav.addObject("message", "Hello World!");
        return mav;
//        return "quotee";
    }
}
