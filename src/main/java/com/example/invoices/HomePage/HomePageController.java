package com.example.invoices.HomePage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/homePage")
@Controller
@RequiredArgsConstructor
public class HomePageController {

  @GetMapping
  public String getHomePage() {
    return "homePage";
  }

}
