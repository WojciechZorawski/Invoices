package com.example.invoices.User;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
@Controller
@RequiredArgsConstructor
public class UserController {

  public List<User> users = new ArrayList<>();

  @GetMapping("/create")
  public String createUser(Model model) {
    model.addAttribute("createdUser", new User());
    return "createUser";
  }

  @PostMapping("/create")
  public String createUser(Model model, @ModelAttribute User newUser) {
    users.add(newUser);
    model.addAttribute("createdUser", newUser);
    return "homePage";
  }

  @GetMapping("/login")
  public String loginUser(Model model, @ModelAttribute User user) {
    if(users.contains(user)){
      model.addAttribute("loggedUser", user);
      return "login";
    }
    return "login";
  }

  @GetMapping("/logged")
  public String loggedUser(Model model){
    model.addAttribute("loggedUser", new User());
    return "invoicesHomePage";
  }

}
