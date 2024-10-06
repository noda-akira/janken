package oit.is.z2394.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JankenController {

  @GetMapping("/janken")
  public String janken(@RequestParam("username") String username, Model model) {
    // Modelにusernameを追加して、janken.htmlで表示できるようにする
    model.addAttribute("username", username);
    return "janken"; // janken.html テンプレートを返す
  }
}
