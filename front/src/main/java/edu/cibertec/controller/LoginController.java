package edu.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sistemaventa")
public class LoginController {
  @GetMapping("/")
  public ModelAndView principal() {
    ModelAndView mv = new ModelAndView("principal");
    return mv;
  }
}
